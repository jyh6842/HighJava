package homework.iBatis.controller;

import java.util.List;
import java.util.Scanner;

import homework.iBatis.service.BoardServiceImp;
import homework.iBatis.service.IBoardService;
import homework.iBatis.vo.BoardVO;
import iBatisModelEx.vo.MemberVO;



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
		System.out.println();
		System.out.println("검색할 정보를 입력하세요 >> ");
		System.out.print("게시판 번호 >> ");
		int board_no = Integer.parseInt(scan.nextLine());
		System.out.print("게시판 제목 >> ");
		String board_title = scan.nextLine();
		System.out.print("작성자 이름 >> ");
		String board_writer = scan.nextLine();
		System.out.print("게시판 내용>> ");
		String board_content = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(board_title);
		bv.setBoard_writer(board_writer);
		bv.setBoard_content(board_content);
		bv.setBoard_no(board_no);
		
		// 입력한 정보를 검색한 내용을 출력하는 부분...
		List<BoardVO> boardList = service.getSearchBoard(bv);
		
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("ID\t이름\t전화번호\t주소");
		System.out.println("----------------------------------");
		
		for (BoardVO bv1 : boardList) {
			System.out.println(bv1.getBoard_no()+"\t" + bv1.getBoard_title()+"\t"+ bv1.getBoard_writer()+"\t" + bv1.getBoard_content()+"\t"+bv1.getBoard_date());
		}
		
	}

	private void displayBoardAll() {
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("게시판번호\t게시판이름\t게시판작성자\t게시판내용\t게시판날짜");
		System.out.println("----------------------------------");

		List<BoardVO> boardList = service.getAllBoardList();

		for (BoardVO bv1 : boardList) {
			
					System.out.println(bv1.getBoard_no()+"\t" + bv1.getBoard_title()+"\t"+ bv1.getBoard_writer()+"\t" + bv1.getBoard_content()+"\t"+bv1.getBoard_date());
		}

		System.out.println("----------------------------------");
		System.out.println("출력 작업 끝...");
		
	}

	private void updateBoard() {
		boolean chk = false; // 중복여부 체크
		int board_no;

		do {
			System.out.println();
			System.out.println("수정할 게시판 정보를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			board_no = Integer.parseInt(scan.nextLine());
			chk = service.getBoard(board_no);
			if (chk != true) {
				System.out.println("게시판 번호가 " + board_no + "인 게시판은 존재하지 않습니다.");
				System.out.println("다시 입력하세요.");
			}
		} while (chk != true);

		System.out.print("업데이트 후 게시판 제목 >> ");
		String board_title = scan.nextLine();

		System.out.print("업데이트 후 게시판 작성자>> ");
		String board_writer = scan.nextLine();

//			scan.nextLine(); // 입력버퍼 지우기 있으면 에러
		System.out.print("업데이트 후 게시판 내용 >> ");
		String board_content = scan.nextLine();
		BoardVO bVo = new BoardVO();
		
		bVo.setBoard_no(board_no);
		bVo.setBoard_title(board_title);
		bVo.setBoard_writer(board_writer);;
		bVo.setBoard_content(board_content);
		

		int cnt = service.updateBoard(bVo);

		if (cnt > 0) {
			System.out.println(board_no + "게시판 정보를 수정했습니다!");
		} else {
			System.out.println(board_no + "게시판 정보 수정 작업 실패!");
		}
		
	}

	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 번호를 입력하세요 >> ");
		int board_no = Integer.parseInt(scan.nextLine());

		int cnt = service.deleteBoard(board_no);

		if (cnt > 0) {
			System.out.println(board_no + "게시판 삭제 성공 ~~~~~");
		} else {
			System.out.println(board_no + "게시판 삭제 실패 ㅠㅠㅠㅠ");
		}
		
	}

	private void insertBoard() {
		boolean chk = false;
		int board_no;
		String board_title;
		String board_writer;
		String board_content;
		
		System.out.println();
		System.out.println("추가할 게시판 정보를 입력하세요.");
		
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
