package javaIOTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class T14_PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		
		// PrintStream 은 모든 자료형을 출력할 수 잇는 기능을 제공하는 OutputStream의 서브 클래스이다.
		// PrintStream은 IOException을 발생시키지 않는다.
		// println()과 print()등 메서드 호출시마다 autoflush 기능 제공함
		PrintStream out = new PrintStream(fos);
//		PrintStream out = new PrintStream(System.out); // 콘솔출력스트림으로 사용됨
		
		out.print("안녕하세요, PrintStream 입니다. \n");
		out.println("안녕하세요, PrintStream 입니다. 2");
		out.println("안녕하세요, PrintStream 입니다. 3");
		
		out.close();
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos2, "UTF-8"));
		writer.print("안녕하세요, PrintWriter 입니다. \r\n");
		writer.println("안녕하세요, PrintWriter 입니다. 2");
		writer.println("안녕하세요, PrintWriter 입니다. 3");
		
		writer.close();
		
		
		
	}
}
