package homework.javaFx.product;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ProductDao {

	private SqlMapClient smc;
	
	private static ProductDao dao;
	
	private ProductDao() {
		Reader rd;
		
		try {
			rd= Resources.getResourceAsReader("SqlMapConfigProduct.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println("sqlmapclient객체 생성 실패");
			e.printStackTrace();
		}
	}
	
	public static ProductDao getInstance() {
		if(dao == null) {
			dao = new ProductDao();
		}
		return dao;
	}
	
	
	public List<ProductVO> getProdl(String prod_lgu) {
		List<ProductVO> prodList = new ArrayList<ProductVO>();
		try {
			prodList = smc.queryForList("prod.getProdl",prod_lgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}
	
	
	
	public ProductVO getProdr(String prod_name) {
		ProductVO pv = new ProductVO();
		try {
			pv = (ProductVO) smc.queryForObject("prod.getProdr",prod_name);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pv;

	}
	
	
	
}
