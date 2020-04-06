package homework.jdbc.MVC.service;

import java.util.List;

import homework.jdbc.MVC.dao.BoardDao;
import homework.jdbc.MVC.vo.BoardVO;

public class BoardService {

	private BoardDao dao;
	
	private static BoardService service;
	
	private BoardService() {
		dao = BoardDao.getInstance();
	}
	
	public static BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
		}
		return service;
	}
	
	// 전체 목록 출력
	public List<BoardVO> viewAllBoard(){
		
		
		return dao.viewAllBoard();
	}
	
	// 새글 작성
	public int insertBoard(BoardVO vo) {
		
		return dao.insertBorad(vo);
	}
	
	// 수정
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}
	
	
	
	// 삭제
	public int deleteBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}
	
	// 검색
	public BoardVO searchBoard(int board_no) {
		return dao.searchBoard(board_no);
	}
	
}
