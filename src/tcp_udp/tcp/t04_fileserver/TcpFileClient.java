package tcp_udp.tcp.t04_fileserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {
	// 클라이언트는 서버에 접속하여
	// 서버가 보내주는 파일을 D드라이브의 C_Lib 폴더에 저장한다.
	private Socket socket;
	private InputStream in;
	private FileOutputStream fout;
	
	public void clientStart() {
		File file = new File("d:/C_Lib/coffe1.jpg");
		
		try {
			socket = new Socket("192.168.206.2", 7777);
			System.out.println("파일 다운로드 시작...");
			
			fout = new FileOutputStream(file);// 상대방이 준걸 여기에 쓰려고
			in = socket.getInputStream();// 소켓에 있는 것 가져오기
			
			byte[] tmp = new byte[1024];
			int length = 0;
			while((length = in.read(tmp)) != -1) {
				fout.write(tmp, 0, length);
			}
			fout.flush(); // close 하면 flush()가 자동으로 되지만 혹시 몰라서
			System.out.println("파일 다운로드 완료...");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {in.close();} catch(IOException e) {}
			}
			if(fout != null) {
				try {fout.close();} catch(IOException e) {}
			}
			if(socket != null) {
				try {socket.close();} catch(IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}
}
