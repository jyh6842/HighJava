package homework.iBatis.service;

import java.util.List;

import homework.iBatis.vo.BoardVO;

public interface IBoardService {

	/**
	 * BoardVO 에 담겨진 자료를 DB에 insert 하는 메서드
	 * @param bv DB에 insert할 자료가 저장된 BoardVO 객체
	 * @return DB 작업이 성공하면 1, 실패하면 0이 반환됨
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 주어진 게시판의 게시물에 번호가 있는지 알아내는 메서드
	 * @param board_no
	 * @return 해당 게시물 번호가 있으면 true, 없으면 false;
	 */
	public boolean getBoard(int board_no);
	
	/**
	 * DB의 jdbc_board 테이블의 전체 레코드를 가져와 List에 담아서
	 * 반환하는 메서드
	 * @return BoardVO 객체를 담고 있는 List 객체
	 */
	public List<BoardVO> getAllBoardList();
	
	/**
	 * 하나의 BoardVO 자료를 이용하여 DB를 update 하는 메서드
	 * @param bv update 할 게시판 정보가 들어 있는 BoardVO 객체
	 * @return 작업 성공 : 1, 작업 실패 : 0 
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 게시판 no 를 매개 변수로 받아서 그 게시판의 정보를 삭제하는 메서드
	 * @param board_no 삭제할 게시판의 게시글 번호
	 * @return 작업성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(int board_no);
	
	/**
	 * BoardVO에 담긴 자료를 이용하여 게시판을 검석하는 메서드
	 * @param bv 검색할 자료가 있는 BoardVO 객체
	 * @return 검색할 결과를 담을 List
	 */
	public List<BoardVO> getSearchBoard(BoardVO bv);
}
