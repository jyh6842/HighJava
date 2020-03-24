package homework;

import java.util.Scanner;

public class JdbcBoard {
/*
	위의 테이블을 작성하고 게시판을 관리하는
	다음 기능들을 구현하시오.

	기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
	 
	------------------------------------------------------------

	게시판 테이블 구조 및 시퀀스

	create table jdbc_board(
	    board_no number not null,  -- 번호(자동증가)
	    board_title varchar2(100) not null, -- 제목
	    board_writer varchar2(50) not null, -- 작성자
	    board_date date not null,   -- 작성날짜
	    board_content clob,     -- 내용
	    constraint pk_jdbc_board primary key (board_no)
	);
	create sequence board_seq
	    start with 1   -- 시작번호
	    increment by 1; -- 증가값
			
	----------------------------------------------------------

	// 시퀀스의 다음 값 구하기
	//  시퀀스이름.nextVal
*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1.전체 목록 출력, 2.새글작성, 3.수정, 4.삭제, 5.검색" );
		int key = Integer.parseInt(sc.nextLine());
		
		switch (key) {
		case 1:
			dispalyAll();
			break;
		case 2:
			insert();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		case 5:
			select();
			break;

		default:
			break;
		}

	}

private  void select() {
		// TODO Auto-generated method stub
		
	}

private  void delete() {
		// TODO Auto-generated method stub
		
	}

private  void update() {
		// TODO Auto-generated method stub
		
	}

private  void insert() {
		// TODO Auto-generated method stub
		
	}

private static void dispalyAll() {
	// TODO Auto-generated method stub
	
}

}
