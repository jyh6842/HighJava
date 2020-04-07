package javaIOTest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07_FileWriterTest {// 871
	public static void main(String[] args) {
		
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//콘솔(표준입출력장치)과 연결된 입력용 문자 스트림 생성
		// InputStreamReader 스트림 => 바이트 기반 스트림을 문자기반 스트림으로 변환해주는 보조 스트림이다.
		InputStreamReader isr = new InputStreamReader(System.in); // 보조스트림은 안에 기본 스트림을 넣어준다. System.in
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("d:/D_Other/testChar.txt");
			int c;
			
			System.out.println("아무거나 입력하세요.");
			// 콘솔에서 입력할 때 입력의 끝표시는 Ctrl + Z키를 누르면 된다.
			while((c=isr.read()) != -1) { // Ctrl + Z == -1, '끝'도 아스킷코드로 무엇인가 있을 것이다.while((c=isr.read()) != '끝')
				fw.write(c);  // 콘솔에서 입력받은 값을 파일에 출력하기
			}
			
			System.out.println("작업 끝...");
			
			isr.close();
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	

	}
		
}
