package collectionTest;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람이름을 입력하여 ArrayList에 저장하고 이 중에 '김'씨 성의 이름을 출력하시오.
 * 		(단, 입력은 Scanner를 이용하여 입력 받는다.)
*/
public class T03_ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> person = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 이름을 입력해주세요");
		for (int i = 0; i < 5; i++) {
			
			System.out.print(i+1 + "번째 이름을 입력해주세요 >> ");
			person.add(sc.nextLine());

		}
		

		
		for (int i = 0; i < person.size(); i++) {
			String name = person.get(i);
			
			if(name.charAt(0) =='김') {
				System.out.println(person.get(i));
			}
			
			if(name.indexOf("김") == 0) {
				System.out.println(person.get(i));
			}
			
			if(name.startsWith("김")) {
				System.out.println(name);
			}
		}
		
		
	}
}
