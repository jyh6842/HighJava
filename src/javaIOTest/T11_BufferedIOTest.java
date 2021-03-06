package javaIOTest;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11_BufferedIOTest { // 884
	public static void main(String[] args) {
		// 입출력의 성능향상을 위해서 버퍼를 이용하는 보조 스트림
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos =  new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼크기가 
			// 8192byte(8kb)로 설정된다.
			
			// 버퍼크기가 5인 스트림 생성
			bos = new BufferedOutputStream(fos, 5);
			for(int i='1'; i<='9'; i++) {
				bos.write(0x0A); // 엔터
				bos.write(i);
			}
			
			//bos.flush(); // 작업을 종료하기 전에 버퍼에 남아있는 데이B터를
			               // 모두 출력시킨다.( close시 자동으로 호출됨.)
			
			bos.close();
			System.out.println("작업 끝...");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
