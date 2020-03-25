package homework.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
//T11
public class CollectionBaseBallTest {
	/*
	 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오 컴퓨터의 숫자는 난수를 이용하여 구한다. (스트라이크는 'S', 볼은
	 * 'B'로 출력한다.)
	 * 
	 * 컴퓨터의 난수가 9 5 7 일때 실행 예시) 숫자 입력 => 3 5 6 3 5 6 ==> 1S 0B 숫자 입력 => 7 8 9 7 8 9
	 * ==> 0S 2B ... 숫자 입력 => 9 5 7 9 5 7 => 3S 0B
	 * 
	 * 5번째 만에 맞췄군요
	 */
	public static void main(String[] args) {

		HashSet<Integer> intRnd = new HashSet<Integer>();
		while(intRnd.size() < 3) {//Set의 데이터가 3개가 될때까지 반복한다.
			int randomNum = (int)(Math.random() * (9) +1); //  1 ~ 100사이의 난수 만들기
			intRnd.add(randomNum); // 중복된 값이 있으면 추가 되지 않기 때문에 다시 돈다.
		}
		
		while (true) {
			Scanner s = new Scanner(System.in);

			int num = 0;
			System.out.print("숫자를 입력해주세요 >> ");
			num = Integer.parseInt(s.nextLine());

			int[] arr = new int[3];

			arr[0] = num / 100;
			arr[1] = (num /10 ) % 10;
			arr[2] = num % 10;
			
			
			
			System.out.println("arr 배열의 값");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();

			

			Iterator it = intRnd.iterator(); // ts를 iterator에 넣어서 꺼내올수 있도록 바꾸자

			int[] setarr = new int[3];
			int i = 0;

			while (it.hasNext()) { // 포인터를 다음 자료 위치로 이동하고, 이동한 위치의 자료를 반환한다. boolean 타입
				setarr[i] = (int) it.next();
				i++;

			}
			
			System.out.println("setarr 배열의 값");
			for (int j = 0; j < setarr.length; j++) {
				System.out.print(" " + setarr[j]);
			}
			

			int st = 0;
			int b = 0;
			int o = 3;

			System.out.println();
			for (i = 0; i < arr.length; i++) {
				for (int j = 0; j < setarr.length; j++) {
					if (i == j && arr[i] == setarr[j]) {
						st++;
					}
					if (i != j && arr[i] == setarr[j]) {
						b++;
					}
					
				}

			}

			System.out.println("S : " + st + ", B : " + b + ", O : " + (o-st-b));

			if (st == 3) {
				System.out.println("정답입니다. ");
				break;
			}

		}

	}

}
