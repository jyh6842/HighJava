package tcp_udp.udp.t01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {
	public void start() throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(); // 소켓 생성
		InetAddress serverAddress = InetAddress.getByName("192.168.206.2"); //InetAddress.getByName("127.0.0.1");
		
		// 데이터가 저장될 공간으로 byte 배영을 생성한다. (패킷 수신용)
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 8888);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		datagramSocket.send(outPacket); // DatagramPacket 전송
		datagramSocket.receive(inPacket); // DatagramPacket 수신
		
		System.out.println("현재 서버 시간 => " + new String(inPacket.getData())); // 바이트 배열을 가져온다. String 에 바이트를 넣어서 바로 실행
		datagramSocket.close();
		
		
	}
	
	public static void main(String[] args) {
		try {
			new UdpClient().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
