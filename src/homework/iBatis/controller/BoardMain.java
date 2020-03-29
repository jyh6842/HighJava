package homework.iBatis.controller;

import java.util.Scanner;

import iBatis2.service.IMemberService;
import iBatis2.service.MemberServiceImpl;

public class BoardMain {

	
	private IMemberService service = new MemberServiceImpl();
	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = Integer.parseInt(scan.nextLine()); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertBoard();
				break;
			case 2: // 자료 삭제
				deleteBoard();
				break;
			case 3: // 자료 수정
				updateBoard();
				break;
			case 4: // 전체 자료 출력
				displayBoardAll();
				break;
			case 5: // 자료 검색
				getSearchBoard();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}
	
	
	private void getSearchBoard() {
		// TODO Auto-generated method stub
		
	}

	private void displayBoardAll() {
		// TODO Auto-generated method stub
		
	}

	private void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	private void deleteBoard() {
		// TODO Auto-generated method stub
		
	}

	private void insertBoard() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}//main

}//BoardMain
