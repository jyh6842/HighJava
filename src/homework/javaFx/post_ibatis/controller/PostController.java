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

public class PostController implements Initializable {

	@FXML
	private ComboBox<String> comSelect;
	@FXML
	private TextField tfield;
	@FXML
	private Button btnseasrch;
	@FXML
	private TableView<PostVO> tv;
	@FXML
	private TableColumn<PostVO, String> tv_zipNum;
	@FXML
	private TableColumn<PostVO, String> tv_si;
	@FXML
	private TableColumn<PostVO, String> tv_gu;
	@FXML
	private TableColumn<PostVO, String> tv_dong;
	@FXML
	private TableColumn<PostVO, String> tv_addr;

	public IPostService service;

	public PostController() {
		service = PostService.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		

		

		tv_zipNum.setCellValueFactory(new PropertyValueFactory<PostVO, String>("zipcode")); // 뒤에 id 가 vo
		tv_si.setCellValueFactory(new PropertyValueFactory<PostVO, String>("sido")); // 뒤에 id 가 vo
		tv_gu.setCellValueFactory(new PropertyValueFactory<PostVO, String>("gugun")); // 뒤에 id 가 vo
		tv_dong.setCellValueFactory(new PropertyValueFactory<PostVO, String>("dong")); // 뒤에 id 가 vo
		tv_addr.setCellValueFactory(new PropertyValueFactory<PostVO, String>("bunji")); // 뒤에 id 가 vo

		comSelect.getItems().addAll("동이름", "우편번호");
		comSelect.setValue(comSelect.getItems().get(0));// 동이름을 초기값으로 주기 위해서


		
		// selectAll 로 전부 가져온다.
//		가져온 정보를 뿌려준다.

		btnseasrch.setOnAction(e -> {

			if (comSelect.getValue().equals(comSelect.getItems().get(0))) {
				System.out.println("여기는 동이름");
				
				List<PostVO> pList = new ArrayList<PostVO>();

				pList = service.getselectPostDong(tfield.getText());
				ObservableList<PostVO> data = FXCollections.observableArrayList();	
				
				for (PostVO postVO : pList) {
					data.add(postVO);
				}
				tv.setItems(data);
				
			} else  {
				System.out.println("여기는 우편변호");
				List<PostVO> pList = new ArrayList<PostVO>();

				pList = service.getselectPostNum(tfield.getText());
				ObservableList<PostVO> data = FXCollections.observableArrayList();	
				
				for (PostVO postVO : pList) {
					data.add(postVO);
				}
				
				tv.setItems(data);

			}

		});

	}// initialize

}
