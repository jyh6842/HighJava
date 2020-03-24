package collectionTest;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1) 5명의 별명을 입력하여 ArrayList에 저장하고 별명의 길이가 제일 긴 별명을 출력하시오.
 * 			(단, 각 별명의 길이는 모두 다르게 입력한다.)
 * 
 * 문제2) 문제 1에서 별명의 길이가 같은 것을 여러개 입력 했을 때에도 처리 되도록 하시오.
*/
public class T04_ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<String> person = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 이름을 입력해주세요");
		for (int i = 0; i < 5; i++) {
			
			System.out.print(i+1 + "번째 이름을 입력해주세요 >> ");
			person.add(sc.nextLine());

		}
		

		String temp = person.get(0);
		String name = person.get(0);
		for (int i = 0; i < person.size(); i++) {
			 name = person.get(i);

			if(temp.length() < name.length() ) {
				temp = name;
			}
		}
		
		System.out.println(temp);
		

		for (int i = 0; i < person.size(); i++) {
			name = person.get(i);

			if(temp.length() == name.length() ) {
				System.out.println(person.get(i));
			}
		}
		
		
		
		
		
		
		
		
		
	}//main
}//T04_ArrayListTest
