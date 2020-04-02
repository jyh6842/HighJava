package iBatisModelEx.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import iBatisModelEx.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
/*
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	*/
	private SqlMapClient smc;

	
	private static IMemberDao dao;
	
	private MemberDaoImpl() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfigIBatisModelEx.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch (IOException e) {
			System.out.println("sqlMapClinet 객체 생성 실패!!!");
			e.printStackTrace();
		}
		
	}
	
	public static IMemberDao getInstance() {
		
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		
		return 	dao;
	}
	

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("member.insertMember", mv); // insert에 성공하면 null을 반환함
			if(obj == null) {
				cnt = 1; // 성공하면 null을 반환하기 때문에 1을 반환하여 성공으로 보내주도록 변경한ㄷ.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean getMember(String memId) {
		boolean chk = false;
		
		try {
			MemberVO mv = (MemberVO) smc.queryForObject("member.getMember", memId);
			
			if(mv != null) {
				chk = true; // 있으면 투루로 리턴 되도록
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList() {

		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = smc.queryForList("member.getMemberAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;

		try {
			cnt = smc.update("member.updateMember", mv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>(); // 예외가 발생하면 null 값이 생기기 때문에 try문에서 쿼리가 없으면 초기화 하지 못하고 빠져 나오기 때문에 생성해줘야한다.
		
		try {
			memList = smc.queryForList("member.getSearchMember", mv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memList;
	}
	

}
