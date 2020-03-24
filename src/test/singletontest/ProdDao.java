package test.singletontest;

import java.util.ArrayList;
import java.util.List;

public class ProdDao {

	private Database db;
	
	private static ProdDao dao;
	
	private ProdDao() {
		db = Database.getInstance();
	}
	
	public static ProdDao getInstance() {
		if(dao == null) {
			dao = new ProdDao();
		}
		
		return dao;
	}
	
	public List<ProdVO> prodList(){
		List<ProdVO> prodList = db.prodList();
		return prodList;
	}
	
	public ProdVO prodInfo(String id) {
		ProdVO pVO = db.prodInfo(id);
		return pVO;
	}
}
