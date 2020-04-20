package tcp.t02;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost" , 7777); // Server 할 사람은 포트만 맞추면됨 Client 가 네트워크번호를 맞추면된다.                    

		System.out.println("서버에 연결되었습니다.");
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}
}
