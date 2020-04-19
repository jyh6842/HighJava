package homework.javaFx.product;


import java.util.List;


public class ProductService {
private ProductDao dao;
	
	private static ProductService service;
	
	private ProductService() {
		dao = ProductDao.getInstance();
	}

	public static ProductService getInstance() {
		if(service == null) {
			service = new ProductService();
		}
		return service;
	}
	
	public List<ProductVO> getProdl(String prod_lgu) {
		return dao.getProdl(prod_lgu);
	}
	
	
	
	public ProductVO getProdr(String prod_name) {
		return dao.getProdr(prod_name);
	}
}
