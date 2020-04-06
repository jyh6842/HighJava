package homework.jdbc.MVC.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homework.jdbc.MVC.service.BoardService;
import homework.jdbc.MVC.vo.BoardVO;



public class BoardMain {


	/*
		회원정보를 관리하는 프로그램을 작성하는데 
		아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
		(DB의 MYMEMBER테이블을 이용하여 작업한다.)
		
		* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
		
		예시메뉴)
		----------------------
			== 작업 선택 ==
			1. 자료 입력			---> insert
			2. 자료 삭제			---> delete
			3. 자료 수정			---> update
			4. 전체 자료 출력	---> select
			5. 작업 끝.
		----------------------
		 
		   
	// 회원관리 프로그램 테이블 생성 스크립트 
	create table mymember(
	    mem_id varchar2(8) not null,  -- 회원ID
	    mem_name varchar2(100) not null, -- 이름
	    mem_tel varchar2(50) not null, -- 전화번호
	    mem_addr varchar2(128)    -- 주소
	);

	*/
	
	/*
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	*/
	
	private BoardService service = BoardService.getInstance();
	private Scanner scan = new Scanner(System.in);


	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 새글 작성");
		System.out.println("  2. 글 삭제");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 글 검색");
		System.out.println("  6. 종료");
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
				insert();
				break;
			case 2: // 자료 삭제
				delete();
				break;
			case 3: // 자료 수정
				update();
				break;
			case 4: // 전체 자료 출력
				viewAll();
				break;
			case 5: // 검색
				select();
				break;
			case 6: // 종료
				System.out.println("종료하겠습니다");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	

	private void select() {
		System.out.print("글 번호를 입력해주세요 >> ");
		int board_no = Integer.parseInt(scan.nextLine());
		BoardVO bVO = new BoardVO();
		bVO = service.searchBoard(board_no);
		
		System.out.println(bVO.getBoard_no());
		System.out.println(bVO.getBoard_title());
		System.out.println(bVO.getBoard_writer());
		System.out.println(bVO.getBoard_date());
		System.out.println(bVO.getBoard_content());
	}

	private void viewAll() {
		System.out.println("전체 목록을 출력합니다.");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		boardList = service.viewAllBoard();
		
		for(BoardVO vo : boardList) {
			System.out.println(vo.getBoard_no());
			System.out.println(vo.getBoard_title());
			System.out.println(vo.getBoard_writer());
			System.out.println(vo.getBoard_date());
			System.out.println(vo.getBoard_content());
		}
	}

	private void update() {
		System.out.print("업데이트 할 게시판 번호를 선택하세요 >> ");
		int board_no = Integer.parseInt(scan.nextLine());
		
		System.out.print("업데이트할 게시판 제목을 입력하세요 >> ");
		String board_title =  scan.nextLine();
		System.out.print("업데이트할 작성자를 입력하세요 >> ");
		String board_writer =  scan.nextLine();
		
		System.out.print("업데이트 할 게시판 내용을 입력하세요 >> ");
		String board_content =  scan.nextLine();
		
		
		
		
		BoardVO vo = new BoardVO();
		
		vo.setBoard_no(board_no);
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		vo.setBoard_content(board_content);
		
		service.updateBoard(vo);
		
		System.out.println("변경된 게시판 내용");
		System.out.println("게시판 번호를 써주세요 변경한 게시판 번호는 >> " + board_no + " 입니다.");
		select();
		
		
		
		
		
		
	}

	private void delete() {
		System.out.print("삭제할 게시판의 번호를 입력해주세요 >> ");
		int board_no = Integer.parseInt(scan.nextLine());
		
		service.deleteBoard(board_no);
	}

	private void insert() {
		
		System.out.print("게시판 제목을 입력하세요 >> ");
		String board_title =  scan.nextLine();
		System.out.print("작성자를 입력하세요 >> ");
		String board_writer =  scan.nextLine();
		
		System.out.print("게시판 내용을 입력하세요 >> ");
		String board_content =  scan.nextLine();
		
		BoardVO vo = new BoardVO();
		
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		vo.setBoard_content(board_content);
		
		service.insertBoard(vo);
		
	}

	public static void main(String[] args) {
		BoardMain boardMain = new BoardMain();
		boardMain.start();
	}

}// MemberMain