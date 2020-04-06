package javaIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class T05_FileStreamTest {
	
	public static void main(String[] args) {
		// FileInputStream 객체를 이용한 파일 내용 읽기
		FileInputStream fin = null;// 변수 선언
		
		
		
		try {
			// 방법 1 (파일 정보를 문자열로 지정하기)
			fin = new FileInputStream("d:/D_Other/test2.txt"); // 생성
			
			// 방법2 (파일 정보를 File 객체를 이용하여 지정하기) // 누가 만들어 놓은거 쓸때는 이거 사용하면 편하다.
			//File file = new File("d:/D_Other/test2.txt");
			//fin = new FileInputStream(file);// 생성
			
			int c; // 읽어온 데이터를 저장할 변수
			
			// 일거온 값이 -1 이면 파일의 끝까지 읽었다는 의미이다.
			while ((c=fin.read()) != -1) { // 1byte 기반씩 읽어온다.
				// 일겅온 자료 출력하기
				System.out.print((char) c);
			}
			fin.close(); // 작업 완료 후 스트림 닫기
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
