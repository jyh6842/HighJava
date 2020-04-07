package javaIOTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest { // 877

	public static void main(String[] args) {

		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		byte[] temp = new byte[4]; // 자료를 읽을때 사용할 배열

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		
		try {
			// available() => 읽어 올 수 있는 byte 수 반환
			while(input.available() > 0 ) {
				/*
				input.read(temp); // temp배열 크기만큼 자료를 읽어와 temp 배열에 저장
				output.write(temp); // temp 배열의 내용을 출력함
				*/
				
				int len = input.read(temp); // 내가 몇 바이트를 읽었는지
				output.write(temp, 0, len); // 0은 기준 인덱스 값, 3번째는 내가 몇바이트를 읽었는지
				// 질문 output을 하지 않으면 input 에 있는 값이 사라지지 않는것인가?
				System.out.println("temp : " + Arrays.toString(temp));
			}
			
			System.out.println();
			outSrc = output.toByteArray();
			
			System.out.println("inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc)); // 3번의 복사를 할때 6, 7 이 붙는 이유는 3번째는 4개의 값을 가져오는 것이 아니라 2개의 값만 가져오기 때문에 3,4 기존에 가져온 값을 가지고 있고 마지막에 가져올때 초기화되지 않았다.
			
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
