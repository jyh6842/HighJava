package collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T13_MapTest {
	public static void main(String[] args) {
		/*
			Map => key 값과 value 값을 한쌍으로 관리하는 객체
				=> key값은 중복을 허용하지 않고 순서가 없다.(Set의 특징)
				=> value값은 중복을 허용한다.
		*/
		
		Map<String, String> map = new HashMap<>();
		
		//자료 추가 => put(key 값, value 값)
		map.put("map", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-1111");
		
		System.out.println("map => " + map);
		
		//자료 수정 => 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		//		 => put(수정할 key값, 새로운 value값)
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		// 자료 삭제 => remove(삭제할 key 값);
		map.remove("name");
		System.out.println("map => " + map);
		
		// 자료 읽기 => get(key값);
		System.out.println("addr = " + map.get("addr"));
		System.out.println("======================================================");
		
		//key 값들을 읽어와 자료를 출력하는 방법
		//방법1 => keySet() 메서드 이용하기
		//		keySet() 메서드 => Map의 key값들만 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
	
		System.out.println("Iterator를 이용하는 방법");
		
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));	
		}
		System.out.println("-------------------------------------------------------");
		
		// 방법2 => Set형의 데이터를 '향상된 for문' 으로 처리하면 Iterator를 사용하지 않아도 된다.
		System.out.println("향상된 for문을 이용한 방법");
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("--------------------------------------------------------");
		
		// 방법3 => value 값만 읽어와 출력하기 => values() 메서드 이용하기
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("---------------------------------------------------------");
		
		// 방법 4 => Map 에는 Entry 라는 내부 클래스가 만들어져 잇따.
		// 			이 Entry 클래스는 key와 value라는 멤버변수로 구성되어 있다.
		//			Map 에서 이 Entry클래스들을 Set형식으로 저장하여 관리한다.
		
		// Entry 객체 전체를 가져오기( 가져온 Entry 객체는 Set 형식으로 되어 있다.)
		// => entrySet() 메서드를 이용하여 가져온다.
		
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		// 가져온 Entry 객체들을 순서대로 처리하기 위해서 Iterator 객체로 반환
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key 값 : " + entry.getKey());
			System.out.println("value 값 : " + entry.getValue());
			System.out.println();
		}
	}
}
