package json.test.read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleReadTest {
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fr = new FileReader("d:/D_Other/myJsonFile.txt"); // file 위치에서 읽어오기
		JSONParser parser = new JSONParser(); // JSONParser 객체생성하기
		
		Object obj = parser.parse(fr); // 파서객체를 파서메소드를 이용해서 Object로 형태로 캐스팅
		JSONObject jsonFile = (JSONObject) obj; // Object형태의 객체를 JSONObject 객체로 변경하기
		
		String name = (String)jsonFile.get("name"); // name이라는 키로 된 값 String name에 저장
		String job = (String)jsonFile.get("job");
		long age = (long)jsonFile.get("age");
		String addr = (String) jsonFile.get("addr");
		
		System.out.println("name : " + name); // 꺼내서 보여주기
		System.out.println("job : " + job);
		System.out.println("age : " + age);
		System.out.println("addr : " + addr);
		
		JSONArray list = (JSONArray) jsonFile.get("singerList"); // List 타입이라서 파싱 작업이 한번 더 필요하다. 
		
		Iterator<JSONObject> it = list.iterator(); // 배열에 들어 있는 값 풀기
		
		JSONObject singer = null;
		while (it.hasNext()) {
			singer = it.next();
			System.out.printf("이름 : %s, \t성별: %s, \t나이: %d\n", 
					singer.get("name"),
					singer.get("gender"),
					singer.get("age")
					);
			
		}
	}
}
