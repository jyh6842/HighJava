package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
//T13
public class CollectionLottoProgram {
//T09_SetTest : 난수 발생 예제가 있다.
	public static void main(String[] args) {
		CollectionLottoProgram t13 = new CollectionLottoProgram();
		
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> intRnd = new HashSet<>();
		TreeSet<Integer> answer = new TreeSet<>();
		
		ArrayList<HashSet<Integer>> countLottoSum = new ArrayList<HashSet<Integer>>();
		
		
		TreeSet<Integer> treeAnswer = t13.LottoAnswer(answer);
		System.out.println("로또 답이 만들어 졌는지 확인");
		System.out.println(treeAnswer);
		
		ArrayList<List> listHashSet = new ArrayList<List>(); // 데이터를 정렬하기 위해서 
		
		

		int inputNumber = 0;
		do {
			t13.menu();
			inputNumber = Integer.parseInt(sc.nextLine());
			if(inputNumber == 1) {
				int money = t13.moneyInputMenu();// 금액 넣는 메서드
				int i = 1;// 입력한 금액으로 몇번 살수 있는지 카운트
				for(i = 1; i <= (money/1000); i++ ) {
//					countLottoSum = new ArrayList<HashSet<Integer>>();
					countLottoSum.add(t13.randomNumberLottoFunc(intRnd));// 랜덤으로 숫자 만들고 ArrayList
					
				}
				// 실제로 몇번 샀는지 
				i--;//1번 빼야 몇번 샀는지 
				
				List<Integer> answerLotto = new ArrayList<Integer>(treeAnswer);
				
				for (int j = 0; j < countLottoSum.size(); j++) {
					HashSet<Integer> count  = countLottoSum.get(j);
					List<Integer> list = new ArrayList<Integer>(count);
					
					//데이터 정렬
					Collections.sort(list);
					System.out.println(list);
					listHashSet.add(list);
					
				}// 배열에 넣기
				
				int[] ok = new int[countLottoSum.size()];//몇개 맞았는지 알려주지 카운트 해주는 배열
				System.out.println("이번주 로또 번호 ");
				System.out.println(answerLotto);
					for (int j = 0; j < listHashSet.size(); j++) {
						for (int k = 0; k < answerLotto.size(); k++) {
							if(answerLotto.get(k).equals(listHashSet.get(j).get(k))) {
								ok[j]++;
							}
						}
					}
					
					
					for (int j = 0; j < ok.length; j++) {
						System.out.println(j +" 번째 로또 : " +ok[j] + " 개 동일 합니다.");
					}
					System.out.println("==========================================");
					for (int j = 0; j < ok.length; j++) {
						if(ok[j] == 3) {
						System.out.println(j +" 번째 로또 : " +ok[j] + " 개 동일 합니다.");
						}	
					}
					System.out.println("==========================================");
					for (int j = 0; j < ok.length; j++) {
						if(ok[j] == 4) {
							System.out.println(j +" 번째 로또 : " +ok[j] + " 개 동일 합니다.");
						}	
					}
					System.out.println("==========================================");
					for (int j = 0; j < ok.length; j++) {
						if(ok[j] == 5) {
							System.out.println(j +" 번째 로또 : " +ok[j] + " 개 동일 합니다.");
						}	
					}
					System.out.println("==========================================");
					for (int j = 0; j < ok.length; j++) {
						if(ok[j] == 6) {
							System.out.println(j +" 번째 로또 : " +ok[j] + " 개 동일 합니다.");
						}	
					}
					
				
				
				
				
				


/*
				int[][] LottoSelect = new int[i][6];
				
				for (int j = 0; j < countLottoSum.size(); j++) {
					HashSet<Integer> count  = countLottoSum.get(j);
					Iterator it = count.iterator();
					
					while(it.hasNext()) {
						for(int k = 0; k < LottoSelect[j].length; k++) {
						LottoSelect[j][k] = it.next();
						}
						//System.out.print(" " + it.next());
					}
					
				}// 배열에 넣기
				
				
				for (int j = 0; j < LottoSelect.length; j++) { // 몇번째 로또
					for (int j2 = 0; j2 < LottoSelect[j].length; j2++) { 
						for (int k = 0; k < LottoSelect[j].length; k++) {
							if (LottoSelect[j][j2] < LottoSelect[j][k]) {
								int temp = LottoSelect[j][j2];
								LottoSelect[j][j2] = LottoSelect[j][k];
								LottoSelect[j][k] = temp;
							}
						}
						
					}
				}
				
				
				//출력
				for (int j = 0; j < LottoSelect.length; j++) {
					for (int j2 = 0; j2 < LottoSelect.length; j2++) {
						System.out.println(LottoSelect[j][j2]);
					}
					
				}
*/
				
				//받은 금액, 거스름 돈
				System.out.println("몇번 샀어요 >> " + i);
				System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + (money % 1000));
				
			}// 구매 선택
			

		} while (inputNumber != 2);

	}//main
	
	public void menu() {
		System.out.println("====================");
		System.out.println(" Lotto 프로그램");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		
		System.out.print("메뉴 선택 : ");
	}//menu
	
	public HashSet<Integer> randomNumberLottoFunc(HashSet<Integer> intRnd) {
		intRnd = new HashSet<Integer>();
		while(intRnd.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			intRnd.add(num);
		}
		
		return intRnd;
		
	}//randomNumberLottoFunc
	
	public TreeSet<Integer> LottoAnswer(TreeSet<Integer> answer) {
		answer = new TreeSet<Integer>();
		while(answer.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			answer.add(num);
		}
		
		return answer;
		
	}
	
	public int moneyInputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 입력 : ");
		int money = Integer.parseInt(sc.nextLine());
		
		return money;
		
	}

}//T13_LottoProgram
