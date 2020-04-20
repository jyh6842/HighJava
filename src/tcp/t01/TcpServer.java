package tcp.t01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer { // 이거 먼저 실행하고 다음에 TcpClient class 를 실행시킨다.
	public static void main(String[] args) throws IOException {
		// TCP 소켓 통신을 하기 위해 ServerSocket 객체 생성
		ServerSocket server = new ServerSocket(7777); // 서버 소켓
		System.out.println("서버가 접속을 기다립니다.");
		
		// accept() 메서드는 Client 에서 연결 요청이 올 때 까지 계속 기다림
		// 연결 요청이 오면 Socket 객체를 생성해서 Client의 Socket과 연결함
		Socket socket = server.accept(); // 여기서 멈춤 (클라이언트가 소켓 요청을 할때까지) server socket 을 받으려구 => 상대방과 둘만의 대화를 하려고 만든 socket 이거 있어야함
		
		//--------------------------------------------------
		// 이 이후는 클라이언트와 연결된 후의 작업을 진행하면 된다.
		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소 : " + socket.getInetAddress());
		
		// Client 에 메시지 보내기
		// OutputStream 객체를 구성하여 전송한다.
		// 접속한 Socket 의 getoutputStream() 메서드를 이용하여 구한다.
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out); // client에 보내려고 OutputStream 을 사용
		dos.writeUTF("어서 오세요..."); // 메시지 보내기
		System.out.println("메시지를 보냈습니다.");
		
		dos.close();
	}
}
