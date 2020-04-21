package tcp_udp.tcp.t01;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "127.0.0.1"; // 내부적으로 사용하는 ip // ipconfig 에서 봤던 ip를 사용해도 된다.
		
		// 자기자신 컴퓨터를 나타내는 방법
		// IP : 127.0.0.1
		// 컴 이름 : localhost
		System.out.println(serverIp + " 서버에 접속 중입니다.");
		
		// 소켓을 생성해서 서버에 연결을 요청한다.
		Socket socket = new Socket(serverIp, 7777); // 7777 int 값이기 때문에서 int 범위 내에서 사용해야하고 다른 프로그램이 쓰지 않는 번호를 사용해야 한다.
		
		// 연결이 되면 이후의 명령이 실행된다.
		System.out.println("연결되었습니다.");
		
		// 서버에서 온 메시지 받기
		// 메시지를 받기 위해 InputStream 객체를 생성한다.
		// Socket 의 getInputStream() 메서드를 이용한다.
		InputStream inputStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(inputStream); 
		
		// 서버로 부터 받은 메시지 출력하기
		System.out.println("받은 메시지 : " + dis.readUTF()); // 상대방이 보낸 것이 문자열일 것이기 때문에 해석하기 위해 readUTF 메서드를 호출하였다.
		System.out.println("연결 종료.");
		
		dis.close();
		
		
	}
}
