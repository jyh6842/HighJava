package javaIOTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest {
	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");
		
		if(f1.exists()) {
			System.out.println(f1.getAbsolutePath() + " 는 존재합니다.");
		}else {
			System.out.println(f1.getAbsolutePath() + "는 없는 파일 입니다.");
			try {
				if(f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + "파일을 새로 만들었습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("2222222222222222222222222222222222222222222222222222222222222");
		System.out.println();
		
		if(f2.exists()) {
			System.out.println(f2.getAbsolutePath() + " 는 존재합니다.");
		}else {
			System.out.println(f2.getAbsolutePath() + "는 없는 파일 입니다.");
			
		}
		System.out.println();
		System.out.println("33333333333333333333333333333333333333333333333333333333333");
		System.out.println();
		
		File f3 = new File("d:/D_Other");
		File[] files = f3.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + "=> ");
			if (files[i].isFile()) {
				System.out.println("파일!");
			}else if (files[i].isDirectory()) {
				System.out.println("디레토리!!");
			}
		}
		
		System.out.println("===========================================================");
		String[] strFiles = f3.list();
		for (String str : strFiles) {
			System.out.println(str);
		}
		System.out.println("------------------------------------------------------------");
		//=============================================================================
		
		// 출력할 디랙토리 정볼르 갖는 File 객체 생성
		System.out.println("44444444444444444444444444444444444444444444444444444444444");
		File f4 = new File("D:/C_Lib");
		
		displayFileList(f4);
		
	}

	private static void displayFileList(File dir) {
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리의 내용");
		
		// 디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		// 하위 데렉토리 정보를ㄹ 저장항 ArrayList 생성 (File 배열의 첨자 저장)
		List<Integer> subDirList = new ArrayList<Integer>();
		
		// 날짜를 출력하기 윟나 형식 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a hh:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr =""; // 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = ""; // 파일 용량
			
			if (files[i].isDirectory()) {
				attr="<DIR>";
				subDirList.add(i);
				
			}else {
				size = files[i].length() + " Byte ";
				attr = files[i].canRead() ? "R" : " ";
				attr += files[i].canWrite() ? "W" : " ";
				attr += files[i].isHidden() ? "H" : " ";
			}
			
			System.out.printf("%s %5s %12s %s\n",
					sdf.format(new Date(files[i].lastModified())), attr, size, files[i].getName());
		}//for 문 끝
		
		int dirCnt = subDirList.size(); // 폴더 안의 하위 폴더 개수 구하기
		int fileCnt = files.length - dirCnt;// 폴더 안의 파일 개수 구하기
		System.out.println(fileCnt + "개의 파일, "+ dirCnt + " 개의 디렉토리");
		System.out.println();
		
		
		for (int i = 0; i < subDirList.size(); i++) {
			// 하위 폴더의 내용들도 출력하기 위해 현재 메서드를
			// 재귀호출하여 처리한다.
			
			displayFileList(files[subDirList.get(i)]);
		}
		
		
		
		
	}
	
	// 지정된 디렉토리(폴더)
	
}
