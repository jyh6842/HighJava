package javaIOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T06_FileStreamTest {
	public static void main(String[] args) {// 868
		// 파일에 출력하기
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/Out.txt");
			for (char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}
			
			System.out.println("파일에 쓰기 작업 완료...");
			// 쓰기 작업 완료 후 스트림 닫기
			fos.close();
			//==============================================
			
			// 정장된 파일의 내용을 읽어ㅘ 화면에 출력하기
			FileInputStream fis = new FileInputStream("d:/D_Other/out.txt");
			
			int c;
			while((c=fis.read()) != -1) {
				System.out.print((char)c);
			}
			
			System.out.println();
			System.out.println("출력 끝...");
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}
