package homework.javaFx.post_ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import homework.javaFx.post_ibatis.vo.PostVO;

public class PostDao implements IPostDao {

	private SqlMapClient smc;
	private static IPostDao postDao;
	
	private PostDao() {
		Reader rd;
		
		try {
			rd = Resources.getResourceAsReader("SqlMapConfigPost.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}
		
	}
	
	public static IPostDao getInstance() {
		if(postDao == null) {
			postDao = new PostDao();
		}
		return postDao;
	}
	
	
	@Override
	public List<PostVO> getselectPostDong(String dongString) {
		List<PostVO> pList = new ArrayList<PostVO>();
		
		try {
			pList = smc.queryForList("post.getPostInfoDong", dongString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public List<PostVO> getselectPostNum(String numString) {
		List<PostVO> pList = new ArrayList<PostVO>();
		
		try {
			pList = smc.queryForList("post.getPostInfoNum", numString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pList;
	}

}
