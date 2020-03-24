package test.singletontest;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private static Database db;
	
	public static Database getInstance() {
		if(db == null) {
			db = new Database();
		}
		return db;
	}
	
	public List<ProdVO> prodList(){
		List<ProdVO> prodList = new ArrayList<>();
		
		String sql = "SELECT * FROM prod";
		
		/*while(조건은 데이터가 있는 동안) {
			ProdVO pVO = new ProdVO();
			pVO.setProd_id("prod_id");
			pVO.setProd_name("prod_name");
			pVO.setProd_lgu("prod_lgu");
			pVO.setProd_buyer("prod_buyer");
			pVO.setProd_cost("prod_cost");
			
			prodList.add(pVO);
		}*/
		
		return prodList;
	}
	
	   public ProdVO prodInfo(String id){
		String sql = "SELECT * FROM prod WHERE prod_id = id";
		ProdVO vo = new ProdVO();
		/*
		vo.setProd_id("prod_id");
		vo.setProd_name("prod_name");
		vo.setProd_lgu("prod_lgu");
		vo.setProd_buyer("prod_buyer");
		vo.setProd_cost("prod_cost");
		*/

		return vo;
	   }


}