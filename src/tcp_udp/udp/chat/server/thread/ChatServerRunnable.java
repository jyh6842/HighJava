package tcp_udp.udp.chat.server.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import tcp_udp.udp.chat.server.vo.ClientVO;

public class ChatServerRunnable implements Runnable{

	//UDP연결을 담당할 소켓
	private DatagramSocket socket = null;
	//클라이언트의 ip주소 리스트 - MainController의 clientList와 같은 주소를 바라보고 있음
	private ObservableList<String> clientList;
	private Map<String, ClientVO> clientMap;
	//서버 실행 여부
	private boolean isServerOn = true;
	
	//생성자
	public ChatServerRunnable(ObservableList<String> clientList, Map<String, ClientVO> clientMap){
		try {
			//객체가 생성될 때 소켓을 7777포트로 초기화
			this.socket = new DatagramSocket(7777);
			//소켓의 타임아웃을 0.5초로 설정 - 클라이언트로부터 데이터가 들어오지 않은채로
			//0.5초가 지나면 타임아웃 익셉션을 발생시키고 넘어가게 됨
			this.socket.setSoTimeout(500);
			//MainController로부터 받은 클라이언트 정보 맵
			this.clientList = clientList;
			this.clientMap = clientMap;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(isServerOn){
			byte[] inMsg = new byte[100];
			DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
			try {
				socket.receive(inPacket);
				final InetAddress address = inPacket.getAddress();
				final int port = inPacket.getPort();
				
				boolean isExist = clientList.contains(address.getHostName()); // 대화명이 존재하는지 확인 없으면 false 있으면 true
			
				if(!isExist){ // 목록에 존재하지 않는 사용자라면..
					Platform.runLater(new Runnable() { // 이게 fx가 돌 수 있도록 하는 것
						
						@Override
						public void run() {
							clientList.add(address.getHostName()); // JavaFx Application 쓰레드 관련 작업임.
						}
					});
					
					ClientVO vo = new ClientVO(address.getHostAddress(), // 생성자 만들기 3개의 정보를 이용해서
												port, 
												new String(inPacket.getData()).trim() // 대화명에서 불필요한 공백 제거.
												);
					clientMap.put(address.getHostName(), vo); // 대화명이 아니라 ipAddress로 해서 아이피정보를 key값으로 만듬
					
				}else{ // 목록에 존재하는 사용자인 경우...(이미 채팅중인 사용자인 경우...)
					 
				
					System.out.println(new String(inPacket.getData()));
					
					Iterator<String> it = clientMap.keySet().iterator();
					
					ClientVO senderVO =  clientMap.get(address.getHostName());
					
					while(it.hasNext()) { // 이걸 추가한 이유는 정상종료가 되지 않은 경우 이미 이전 포트 번호를 가지고 있고  새로 들어오면 다시 접속한 사람은 이전 포트를 가지고 있기 때문에 잘 안되는 버그 발생 새로
						String ipAddr = it.next();
						ClientVO vo = clientMap.get(ipAddr); // 해당 아이피 주소 가지고 오기
						InetAddress ipAddress = InetAddress.getByName(vo.getIpAddr());
						DatagramPacket outPacket = null;
						if(address.getHostName().equals(vo.getIpAddr()) 
							&& (port != vo.getPortNum())) { // 아이피주소는 동일한데 포트번호가 다른경우...
							vo.setPortNum(port); // 지금 따끈따끈한 포트 번호로 바꿔 준다.
							clientMap.put(ipAddr, vo); // 기존 정보 갱신
						}
						
						String sendMsg = "[" + senderVO.getChatName() + "] " + new String(inPacket.getData()); // 닉네임  + 채팅 내용
						
						System.out.println("메시지 : " + sendMsg);
						outPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.getBytes().length, ipAddress, vo.getPortNum()); // 바이트 베열로 바꾸고
						socket.send(outPacket); // 접속한 클라이언트에게 메시지 전송
					}
				}
				
				//Thread.sleep(500);
			} catch(SocketTimeoutException e){	
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void turnOffServer(){
		isServerOn = false;
	}
}
