package tcp_udp.udp.t01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
   private DatagramSocket socket;
   
   public void start() throws IOException{
      
      socket = new DatagramSocket(8429); // 포트번호 8429번을 사용하는 소켓 생성 // 상대방에게 던질 때 사용
      DatagramPacket inPacket, outPacket; // 패킷송수신을 위한 객체변수생성 // 데이터를 담기 위해서(데이터를 받을, 데이터를 보낼) 그래서 2개 만듬
      
      byte[] inMsg = new byte[1]; //패킷수신을 위한 바이트배열 선언
      byte[] outMsg ;
      
      while(true) {
         // 데이터를 수신하기 위한 패킷을 생성한다.
         inPacket = new DatagramPacket(inMsg, inMsg.length);
         System.out.println("패킷 수신 대기중");
         
         //패킷을 통해 데이터를 수신(receive)한다.
         socket.receive(inPacket); // 보낼때도 쓰고 받을때도 쓴다. 이 쓰레드 블락됨 상대방이 패킷을 던져서 내가 받을때가 블락 됨 // 연결 지향이 아니기 때문에 받을 준비를 하고 있어야한다.?
         
         System.out.println("패킷 수신 완료"); 
         
         //수신한 패킷으로 부터 client의 IP주소와 Port번호를 얻는다.
         
         InetAddress address = inPacket.getAddress(); // 보낸 사람이 누군지를 모르기때문에 상대방이 먼저 패킷정보 받은 것을 분석해서 어느 포트를 통해서 던졌구나를 여기서 하는것. 그래야 상대방에게 보낼 수 있다. 의미없는 패킷을 먼저 받는다.
         int port = inPacket.getPort();
         
         // 서버의 현재 시간을 시, 분, 초 형태 ([hh:mm:ss])로 반환한다.
         
         SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
         
         String time = sdf.format(new Date());
         outMsg = time.getBytes(); // 시간문자열을 byte배열로 변환한다.
         
         //패킷을 생성해서 client에게 전송(send)한다.
         outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);// 보낼 바이트 배열, 사이즈, 상대방이 보낸 주소(상대방 주소)와 포트
         
         socket.send(outPacket); // 전송시작
      }
      
   }
   
   public static void main(String[] args) throws IOException {
      new UdpServer().start();
   }
}