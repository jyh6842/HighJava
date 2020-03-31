package homework.iBatis.controller;

import java.util.Scanner;

import homework.iBatis.service.BoardServiceImp;
import homework.iBatis.service.IBoardService;
import homework.iBatis.vo.BoardVO;



public class BoardMain {

	
	private IBoardService service = BoardServiceImp.getInstance();
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
		boolean chk = false;
		int board_no;
		String board_title;
		String board_writer;
		String board_content;
		
		do {
			System.out.println();
			System.out.println("추가할 게시판 정보를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			board_no = Integer.parseInt(scan.nextLine());
			
			chk = service.getBoard(board_no);

			if (chk == true) {
				System.out.println("추가할 게시판 번호가 " + board_no + "인 게시판은 이미 존재합니다.");
				System.out.println("다시 입력하세요.");
			}
			
		} while (chk == true);
		
		
		System.out.print("제목 >>");
		board_title = scan.nextLine();
		System.out.print("작성자 >>");
		board_writer = scan.nextLine();
		System.out.print("내용 >>");
		board_content = scan.nextLine();
		
		BoardVO bVo = new BoardVO();
		
		
		bVo.setBoard_title(board_title);
		bVo.setBoard_writer(board_writer);
		bVo.setBoard_content(board_content);

		
		int cnt = service.insertBoard(bVo);
		
		if(cnt > 0) {
			System.out.println("게시판 추가 작업 성공 ~~");
		}else {
			System.out.println("게시판 추가 작업 실패 ㅠㅠ");
		}

		
	}

	public static void main(String[] args) {
		BoardMain boardMain = new BoardMain();
		boardMain.start();

	}//main

}//BoardMain
