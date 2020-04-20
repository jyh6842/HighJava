package javanetworkTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class T03_URLConnectionTest { // 954
	public static void main(String[] args) throws IOException {
		// URLConnection => 애플리케이션과 URL 간의 통신 연결을 위한 추상 클래스
		
		// 특정 서버 (예: naver서버)의 정보와 파일 내용을 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");
		
		// Header 정보 가져오기
		
		// URLConnection 객체 구하기
		URLConnection urlCon = url.openConnection();
		
		System.out.println("Content-Type : " + urlCon.getContentType());
		System.out.println("Encoding : " + urlCon.getContentEncoding());
		System.out.println("Content : " + urlCon.getContent()); // Object로 가져온다. 그래서 Stream으로 가지고 와야한다. url 
		
		// 전체 Header 정보 출력하기
		Map<String, List<String>> headerMap = urlCon.getHeaderFields(); // 여기서 왜 List<string>>을 사용?
		
		//Header 의 key값 구하기
		Iterator<String> iterator = headerMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " : " + headerMap.get(key));
			
			
		}
		System.out.println("----------------------------------------------");
		
		// 해당 호스트의 페이지 내용 가져오기
		// 파일을 읽어오기 위한 스트림 생성
		// 방법1 => URLConnection의 getInputStream 메서드 이용하기
		// InputStream is = urlCon.getInputStream();
		
		// 방법2 => URL 객체의 openStream() 메서드 이용하기
		// InputStream is = url.openStream();
		 
		// 방법 1을 이용해서 가져온것?
		InputStream is = url.openConnection().getInputStream();
		
		InputStreamReader isr = new InputStreamReader(is, "utf-8"); // byte 기반을 문자기반으로 바꿔준다.
		BufferedReader br = new BufferedReader(isr); // 속도 향상을 위해서 사용하는 보조 스트림
		
		// 내용 출력하기
		while (true) {
			String str = br.readLine();// 한줄 한줄 읽기읽는 메서드
			if(str == null) { // 읽을 데이터가 없으면 null을 리턴
				break;
			}
			System.out.println(str);
		}
		// 스트림 닫기
		br.close();
		
		
		
		
		
		
	}
}
