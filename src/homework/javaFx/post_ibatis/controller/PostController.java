package homework.javaFx.post_ibatis.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import homework.javaFx.post_ibatis.service.IPostService;
import homework.javaFx.post_ibatis.service.PostService;
import homework.javaFx.post_ibatis.vo.PostVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PostController implements Initializable{

	@FXML ComboBox<String> comSelect;
	@FXML TextField tfield;
	@FXML Button btnseasrch;
	@FXML TableView<PostVO> tv;
	@FXML TableColumn<PostVO, String> tv_zipNum;
	@FXML TableColumn<PostVO, String> tv_si;
	@FXML TableColumn<PostVO, String> tv_gu;
	@FXML TableColumn<PostVO, String> tv_dong;
	@FXML TableColumn<PostVO, String> tv_addr;
	
	private IPostService service;
	
	private PostController() {
		service = PostService.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ObservableList<PostVO> data = FXCollections.observableArrayList();
		
		tv.setItems(data);
		
		tv_zipNum.setCellValueFactory(new PropertyValueFactory<PostVO, String>("id")); // 뒤에 id 가 vo
		tv_si.setCellValueFactory(new PropertyValueFactory<PostVO, String>("sido")); // 뒤에 id 가 vo
		tv_gu.setCellValueFactory(new PropertyValueFactory<PostVO, String>("gugun;")); // 뒤에 id 가 vo
		tv_dong.setCellValueFactory(new PropertyValueFactory<PostVO, String>("dong;")); // 뒤에 id 가 vo
		tv_addr.setCellValueFactory(new PropertyValueFactory<PostVO, String>("bunji;")); // 뒤에 id 가 vo
		
		comSelect.getItems().addAll("동이름", "우편번호");
		comSelect.setValue(comSelect.getItems().get(0));// 동이름을 초기값으로 주기 위해서
		
		
		btnseasrch.setOnAction(e->{
			
			
			if(comSelect.getItems().get(0).equals("동이름")) {
//				List<PostVO> pList = new ArrayList<PostVO>();
				
//				pList = service.getselectPostDong(tfield.getText());
//				
//				for (PostVO postVO : pList) {
//					 postVO = (PostVO) pList;
//					 data.add(postVO);
//				}
				
				
			}else {
				
			}
			
			
		});
		
		
		
		
		
	}// initialize
	
}
