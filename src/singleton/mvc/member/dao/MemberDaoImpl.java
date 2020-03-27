package singleton.mvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import singleton.mvc.member.vo.MemberVO;
import singleton.mvc.util.DBUtil;
import singleton.mvc.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	
	private static IMemberDao dao;
	
	private MemberDaoImpl() {}
	
	public static IMemberDao getInstance() {
		
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		
		return 	dao;
	}
	
	

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

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_tel());

			cnt = pstmt.executeUpdate();

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

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			
			// Dynamic Query 라고 함 뒤에 상황에 따라서 바뀌는 쿼리
			String sql = "SELECT * FROM mymember WHERE 1=1 "; // 1=1을 넣으면 다음 쿼리를 넣을 때 and를 붙이면 되는 편리함이 생김
			
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) { //가지고 온게 null 아닌지 확인하고, nullString이 아니라면
				sql += " and mem_id = ? ";  
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) { //가지고 온게 null 아닌지 확인하고, nullString이 아니라면
				sql += " and mem_name = ? ";  
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) { //가지고 온게 null 아닌지 확인하고, nullString이 아니라면
				sql += " and mem_tel = ? ";  
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) { //가지고 온게 null 아닌지 확인하고, nullString이 아니라면
				sql += " and mem_addr like '%'|| ? ||'%' ";  //어디 사람인지
			}
			
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				pstmt.setString(index++, mv.getMem_id());
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				pstmt.setString(index++, mv.getMem_name());
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				pstmt.setString(index++, mv.getMem_tel());
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				pstmt.setString(index++, mv.getMem_addr());
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO mv2 = new MemberVO();
				mv2.setMem_id(rs.getString("mem_id"));
				mv2.setMem_name(rs.getString("mem_name"));
				mv2.setMem_tel(rs.getString("mem_tel"));
				mv2.setMem_addr(rs.getString("mem_addr"));

				memList.add(mv2);

			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return memList;
	}

}
