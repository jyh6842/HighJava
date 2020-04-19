package homework.javaFx.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;


public class ProductManagementController implements Initializable {

	
	private ProductService service = ProductService.getInstance();
	
	@FXML 
	private TableColumn<ProductVO,String> prod_id;
	@FXML 
	private TableColumn<ProductVO,String> prod_name;
	@FXML 
	private TableColumn<ProductVO,String> prod_lgu;
	@FXML 
	private TableColumn<ProductVO,String> prod_buyer;
	@FXML 
	private TableColumn<ProductVO,String> prod_cost;
	@FXML 
	private TableColumn<ProductVO,String> prod_price;
	@FXML 
	private TableColumn<ProductVO,String> prod_sale;
	@FXML 
	private TableColumn<ProductVO,String> prod_outline;
	@FXML 
	private TableColumn<ProductVO,String> prod_detail;
	
	@FXML TableView<ProductVO> tv;
	@FXML ComboBox<String> lcb;
	@FXML ComboBox<String> rcb;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		prod_id.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
		prod_name.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
		prod_lgu.setCellValueFactory(new PropertyValueFactory<>("prod_lgu"));
		prod_buyer.setCellValueFactory(new PropertyValueFactory<>("prod_buyer"));
		prod_cost.setCellValueFactory(new PropertyValueFactory<>("prod_cost"));
		prod_price.setCellValueFactory(new PropertyValueFactory<>("prod_price"));
		prod_sale.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
		prod_outline.setCellValueFactory(new PropertyValueFactory<>("prod_outline"));
		prod_detail.setCellValueFactory(new PropertyValueFactory<>("prod_detail"));
		
		
		ObservableList<String> firstl = FXCollections.observableArrayList("컴퓨터제품","전자제품","여성캐주얼","남성캐주얼","패션잡화","화장품","음반/CD","도서","문구류");
		lcb.setItems(firstl);
		/*
		 * ObservableList<String> firstr =
		 * FXCollections.observableArrayList("모니터 삼성전자15인치칼라","모니터 삼성전자17인치칼라"
		 * ,"모니터 삼성전자19인치칼라","삼보컴퓨터 P-III 600Mhz","삼보컴퓨터 P-III 700Mhz"
		 * ,"삼보컴퓨터 P-III 800Mhz"); rcb.setItems(firstr);
		 */
		
		lcb.setOnAction(e->{
			ObservableList<ProductVO> data = FXCollections.observableArrayList();
			String l = lcb.getValue();
			String sl = "";
			if(l.equals("컴퓨터제품")) {
				sl="P101";
			}else if(l.equals("전자제품")){
				sl="P102";
			}else if(l.equals("여성캐주얼")){
				sl="P201";
			}else if(l.equals("남성캐주얼")){
				sl="P202";
			}else if(l.equals("패션잡화")){
				sl="P301";
			}else if(l.equals("화장품")){
				sl="P302";
			}else if(l.equals("음반/CD")){
				sl="P401";
			}else if(l.equals("도서")){
				sl="P402";
			}else{
				sl="P403";
			}
			
			List<ProductVO> list = new ArrayList<>();
			list =  service.getProdl(sl);
			//System.out.println(list);
			data = FXCollections.observableArrayList(list);
			//System.out.println(data);
			tv.setItems(data);
			
			int listsize = list.size();
			//System.out.println(list.size());
			
			ObservableList<String> sList = FXCollections.observableArrayList();
			for(int i=0; i<listsize; i++) {
				sList.add(list.get(i).getProd_name());
			}
			//System.out.println(sList);
			rcb.setItems(sList);
		});
		
		rcb.setOnAction(e1->{
			ObservableList<ProductVO> data = FXCollections.observableArrayList();	
			String r = rcb.getValue();
			ProductVO rv = new ProductVO();
			rv= service.getProdr(r);
			data = FXCollections.observableArrayList(rv);
			tv.setItems(data);
		});
		
		
		
	}
}
