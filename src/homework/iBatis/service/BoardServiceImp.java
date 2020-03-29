package homework.iBatis.service;

import java.util.List;

import homework.iBatis.dao.BoardDaoImp;
import homework.iBatis.dao.IBoardDao;
import homework.iBatis.vo.BoardVO;

public class BoardServiceImp implements IBoardService{
	
	private IBoardDao dao;
	
	private static BoardServiceImp service;
	
	private BoardServiceImp() {
		dao = BoardDaoImp.getInstance();
	}
	
	public static BoardServiceImp getInstance() {
		if(service == null) {
			service = new BoardServiceImp();
		}
		return service;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		return dao.insertBoard(bv);
	}

	@Override
	public boolean getBoard(int board_no) {
		
		return dao.getBoard(board_no);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		// TODO Auto-generated method stub
		return dao.getAllBoardList();
	}

	@Override
	public int updateBoard(BoardVO bv) {
		// TODO Auto-generated method stub
		return dao.updateBoard(bv);
	}

	@Override
	public int deleteBoard(int board_no) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(board_no);
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		// TODO Auto-generated method stub
		return dao.getSearchBoard(bv);
	}

}
