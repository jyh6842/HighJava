package mvc_and_log4j.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import mvc_and_log4j.member.vo.MemberVO;
import mvc_and_log4j.util.DBUtil;

public class MemberDaoImpl implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final Logger sqlLogger = Logger.getLogger("log4jexam.sql.Query"); // 로거 생성
	private final Logger paramLogger = Logger.getLogger("log4jexam.sql.Query"); // 로거 생성
	private final Logger resultLogger = Logger.getLogger(MemberDaoImpl.class); // 로거 생성 // 해당클래스에 해당하는 로거를 생성함

	/**
	 * 자원 반납용 메소드
	 */
	private void disConnect() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ee) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ee) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ee) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ee) {
			}

	}

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();

			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values(?, ?, ?, ?)";

			//sqlLogger.debug("쿼리 : "+sql);// logger
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_tel());
			
			/*paramLogger.debug("파라미터 : (" + mv.getMem_id()
											+ ", " + mv.getMem_name() 
											+ ", " + mv.getMem_tel() 
											+ ", " + mv.getMem_addr() + ")");
			*/
			cnt = pstmt.executeUpdate();
			/*
			resultLogger.warn("결과 : "+cnt);
*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public boolean getMember(String memId) {
		boolean chk = false;

		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) as cnt from mymember" + " where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList() {

		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = DBUtil.getConnection();

			String sql = "select * from mymember";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));

				memList.add(mv);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return memList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;

		try {
			conn = DBUtil.getConnection();

			String sql = "UPDATE mymember SET mem_id=?, mem_name=?, mem_tel=?, mem_addr=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_addr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();

			String sql = "DELETE FROM mymember WHERE mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

}
