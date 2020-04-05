package homework.jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import homework.jdbc.mvc.db.DBUtil;
import homework.jdbc.mvc.vo.BoardVO;

public class BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDao dao;
	
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}
	
	/**
	 * 자원 반납용 메서드
	 */
	private void disConnect() {
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
//		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}		
	}
	
	// 전체 목록 출력
	public List<BoardVO> viewAllBoard(){
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		conn = DBUtil.getInstance();
		String sql = "SELECT * FROM jdbc_board";
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				
				bVO.setBoard_no(rs.getInt("board_no"));
				bVO.setBoard_title(rs.getString("board_title"));
				bVO.setBoard_writer(rs.getString("board_writer"));
				bVO.setBoard_date(rs.getDate("board_date"));
				bVO.setBoard_content(rs.getString("board_content"));
				
				boardList.add(bVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return boardList;
	}
	
	// 새글 작성
	public int insertBorad(BoardVO vo) {
		
		int cnt = 0;
		conn = DBUtil.getInstance();
		String sql = "INSERT INTO jdbc_board VALUES(board_seq.nextVal,?,?,sysdate,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBoard_title());
			pstmt.setString(2, vo.getBoard_writer());
			pstmt.setString(3, vo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
		
	}
	
	// 수정
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		
		conn = DBUtil.getInstance();
		
		String sql = "UPDATE jdbc_board SET board_title=?, board_writer=?, board_content=?, board_date=sysdate WHERE board_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBoard_title());
			pstmt.setString(2, vo.getBoard_writer());
			pstmt.setString(3, vo.getBoard_content());
			pstmt.setInt(4, vo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
		
	}
	
	
	// 삭제
	public int deleteBoard(int board_no) {
		int cnt = 0;
		
		conn = DBUtil.getInstance();
		String sql = "DELETE FROM jdbc_board WHERE board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	// 검색
	public BoardVO searchBoard(int board_no) {
		boolean chk = false;
		BoardVO bVO = new BoardVO();
		conn = DBUtil.getInstance();
		
		String sql = "SELECT * FROM jdbc_board WHERE board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			chk = true;
			bVO = new BoardVO();
			
			bVO.setBoard_no(rs.getInt("board_no"));
			bVO.setBoard_title(rs.getString("board_title"));
			bVO.setBoard_writer(rs.getString("board_writer"));
			bVO.setBoard_content(rs.getString("board_content"));
			bVO.setBoard_date(rs.getDate("board_date"));
			
			return bVO;
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return bVO;
	}
	
	
	
	
	
	
	
	
	
	
	
}//BoardDao
