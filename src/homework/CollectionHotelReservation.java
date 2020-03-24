package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionHotelReservation {
	Scanner sc = new Scanner(System.in);
	Map<String, String> roomMap = new HashMap<String, String>();

	public static void main(String[] args) {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		new CollectionHotelReservation().menu();
	}// main

	public void menu() {
		while (true) {
			

			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");

			System.out.print("메뉴선택 >> ");
			int selectMenuNum = Integer.parseInt(sc.nextLine());

			switch (selectMenuNum) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				EnterpriseCheckRoom();
				break;
			case 4:
				System.out.println("업무를 종료하겠습니다.");
				if (selectMenuNum == 4) {
					break;
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}

			
		} // while
	}

	private void EnterpriseCheckRoom() {
		Set<String> keySet = roomMap.keySet();
		for(String key  : keySet) {
			System.out.println("방번호 : " +key+ "투숙객 : " + roomMap.get(key));
		}

	}

	private void checkOut() {
		System.out.println("어느방에 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 =>");
		String roomNum = sc.nextLine();
		if (!roomMap.containsKey(roomNum)) { // 방에 사람이 있으면 break;
			System.out.println("방을 잘못 입력하셨습니다.");
			return;
		}
		roomMap.remove(roomNum);

	}

	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 =>");
		String roomNum = sc.nextLine();
		if (roomMap.containsKey(roomNum)) { // 방에 사람이 있으면 break;
			System.out.println("이미 체크인된 방입니다.");
			return;
		}
		System.out.print("이름을 입력해주세요 >>");
		String roomGesut = sc.nextLine();
		roomMap.put(roomNum, roomGesut);

	}

}// CollectionHotelReservation


