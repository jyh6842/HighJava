package tcp_udp.udp.t02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpFileClient {
	public static final int BUFFER_SIZE = 10000;
	
	public static void main(String[] args) throws IOException {
		int port = 8429;
		
		long fileSize;
		long totalReadByte = 0;
		
		byte[] buffer = new byte[BUFFER_SIZE];
		int nReadSize = 0;
		System.out.println("파일 수신 대기중...");
		
		DatagramSocket ds = new DatagramSocket(port);
		FileOutputStream fos = new FileOutputStream("d:/C_Lib/Tulips.jpg");
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);
		String str = new String(dp.getData()).trim();
		
		if(str.equals("start")) { // sender 에서 전송을 시작한 경우
			dp = new DatagramPacket(buffer,  buffer.length);
			ds.receive(dp); // 여기서 블락됨
			
			// str = new String(dp.getData()).trim(); // 필요 없음
			fileSize = Long.parseLong(str);
			double startTime = System.currentTimeMillis();
			while(true) {
				ds.receive(dp); // 여기서 블락됨 데이터를 받을 때 까지
				str = new String(dp.getData()).trim();
				nReadSize = dp.getLength();
				fos.write(dp.getData());
				totalReadByte += nReadSize;
				System.out.println("진행 중 : " + totalReadByte + "/" + fileSize + " Bytes(" + (totalReadByte * 100 / fileSize) + "%)");
				
				if(totalReadByte >= fileSize) {
					break;
				}
			}
			double endTime = System.currentTimeMillis();
			double diffTime = (endTime - startTime) / 1000;
			double transferSpeed = (fileSize / 1000) / diffTime;
			
			System.out.println("걸린 시간 : " + diffTime + "seconds");
			System.out.println("평균 전송 속도 : " + transferSpeed + " KB/s");
			System.out.println("전송 완료 !!! ");
			
			fos.close();
			ds.close();
			
		}else {
			System.out.println(" 수신 처리 불가 !!! ");
			fos.close();
			ds.close();
		}
		
		
	}
}
