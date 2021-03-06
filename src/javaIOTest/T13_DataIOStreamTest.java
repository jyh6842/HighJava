package javaIOTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * 기본 타입 입풀력 보조 스트림 예제
 *
 */
public class T13_DataIOStreamTest { // 886
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("d:/D_Other/test.dat");

			// DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해준다
			DataOutputStream dos = new DataOutputStream(fos);

			dos.writeUTF("홍길동");// 문자열 데이터 출력(UTF-8);
			dos.writeInt(17); // 정수형으로 데이터 출력
			dos.writeFloat(3.14f); // 실수형(Float)으로 출력
			dos.writeDouble(3.14); // 실수형(Double)으로 출력
			dos.writeBoolean(true); // 논리형으로 출력
			System.out.println("출력완료..");

			dos.close();
			// ===========================================
			// 출력한 자료 읽어오기
			FileInputStream fis = new FileInputStream("d:/D_Other/test.dat");
			DataInputStream dis = new DataInputStream(fis);

			System.out.println("문자열 자료 :" + dis.readUTF()); // 위에서 저장한순서데로 써줘야함 아니면 값이다르게나옴
			System.out.println("정수형 자료 :" + dis.readInt());
			System.out.println("실수형(Float) 자료 :" + dis.readFloat());
			System.out.println("실수형 자료(Double) :" + dis.readDouble());
			System.out.println("논리형 자료 :" + dis.readBoolean());

			dis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}