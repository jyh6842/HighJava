package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 빨간색이 떠야 해 안뜨면 이상한거야
public class T18_SyncCollectionTest {
	/*
	 	Vector, Hahshtable 등의 예전부터 존재하던 Collection 들은 내부에 
	 	동기화 처리되어 있다.
	 	그런데, 최근에 새로 구성된 Collection들은 동기화 처리가 되어 있지 않다.
	 	그래서 동기화가 필요한 프로그램에서 이런 Collection 들을 사용하려면
	 	동기화 처리를 한 후에 사용해야 한다.
	*/
	// 동기화를 하지 않을 경우
	private static List<Integer> list1 = new ArrayList<Integer>();
	
	// 동기화 하는 경우
	// Collections 의 정적 메서드 중에서 synchronized 로 시작하는 메서드 이용
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) {
		// 익명 클래스로 구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 10000; i++) {
					//list1.add(i); // 동기화 처리하지 않은 리스트 사용
					list2.add(i); // 동기화
				}
				
			}
		};
		
		Thread[] ths = new Thread[] {
				new Thread(r), new Thread(r),
				new Thread(r), new Thread(r),
				new Thread(r)
		};
		
		for (Thread th : ths) {
			th.start();
		}
		
		for (Thread x : ths) {
			try {
				x.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//for
		
//		System.out.println("list의 개수 : " + list1.size());
		System.out.println("list의 개수 : " + list2.size());
		
	}
}
