package homework.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tulips {

	public static void main(String[] args) {
		FileInputStream fin = null;
		FileOutputStream fos = null;
		
		try {
			//fin = new FileInputStream("e:/D_Other/Tulips.jpg");
			File file = new File("d:/D_Other/Tulips.jpg");
			fin = new FileInputStream(file);
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			
			int c = 0;
			while ((c=fin.read())!=-1) {
				fos.write(c);
			}
			System.out.println("작업완료");
			fin.close();
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
