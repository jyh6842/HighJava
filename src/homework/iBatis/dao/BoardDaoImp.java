package homework.iBatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import homework.iBatis.vo.BoardVO;

public class BoardDaoImp implements IBoardDao{
	
	private SqlMapClient smc;
	
	private static IBoardDao dao;
	
	private BoardDaoImp() {
		Reader rd;
		
		try {
			rd = Resources.getResourceAsReader("SqlMapConfigBoard.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("sqlMapClient 객체 생성 실패!!!");
			e.printStackTrace();
		}
	}
	
	public static IBoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDaoImp();
		}
		return dao;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("board.insertboard", bv);
			if(obj == null) {
				cnt = 1; //insert 는 null 이 되면 성공한 것
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean getBoard(int board_no) {
		boolean chk = false;
		
		try {
			BoardVO bv = (BoardVO) smc.queryForObject("board.getBoard", board_no);
			
			if(bv != null) {
				chk = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			boardList = smc.queryForList("board.getBoardAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = smc.update("board.updateBoard", bv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {
		int cnt = 0;
		try {
			cnt = smc.delete("board.deleteBoard", board_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			boardList = smc.queryForList("board.getSearchBoard", bv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardList;
	}

}
