package test.singletontest;

import java.util.List;

public class ProdService {
	
	private ProdDao dao;
	
	private static ProdService service;
	
	private ProdService() {
		dao = ProdDao.getInstance();
	}
	
	public static ProdService getInstance() {
		if(service == null) {
			service = new ProdService();
		}
		
		return service;
	}
	
	public List<ProdVO> prodList(){
		List<ProdVO> prodList = dao.prodList();
		return prodList;
	}
	
	public ProdVO prodInfo(String id) {
		ProdVO pVO = dao.prodInfo(id);
		return pVO;
	}
}
