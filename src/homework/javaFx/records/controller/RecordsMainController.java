package homework.javaFx.records.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.undo.StateEdit;

import homework.javaFx.records.util.DataShare;
import homework.javaFx.records.vo.recordsVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RecordsMainController implements Initializable{

	@FXML private TableView<recordsVO> tv;
	@FXML private TableColumn<recordsVO, String> colname;
	@FXML private TableColumn<recordsVO, Integer> colkorean;
	@FXML private TableColumn<recordsVO, Integer> colmath;
	@FXML private TableColumn<recordsVO, Integer> colenglish;
//	@FXML private Button btn_add;
//	@FXML private Button btn_graph;

	private ObservableList<recordsVO> recordsData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		colname.setCellValueFactory(new PropertyValueFactory<recordsVO, String>("name"));
		colkorean.setCellValueFactory(new PropertyValueFactory<recordsVO, Integer>("kor"));
		colmath.setCellValueFactory(new PropertyValueFactory<recordsVO, Integer>("math"));
		colenglish.setCellValueFactory(new PropertyValueFactory<recordsVO, Integer>("eng"));
		
		recordsData = FXCollections.observableArrayList();
		
		recordsData = DataShare.recordsList;
		
		
		
		
		tv.setItems(recordsData);
				
	}

	@FXML public void addStudent(MouseEvent event) {
		 // 새창을 띄우자
		
		// 1. Stage 객체 생성
		Stage addStudentDiaglog = new Stage(StageStyle.UTILITY);
		
		// 2. 모달창 여부 설정
		// 모달창은 자식창이 나타나면 부모창을 사용할 수 없다. // 다른거 활성화 못시키게 막아버리기
		addStudentDiaglog.initModality(Modality.APPLICATION_MODAL);
		
		// 3. 부모창 지정
		addStudentDiaglog.initOwner(tv.getScene().getWindow());
		
		addStudentDiaglog.setTitle("학생의 성적 추가");
		
		// 4. 자식창에 나타날 컨테이너 설정
		Parent parent = null;
		
		try {
			parent = new FXMLLoader().load(getClass().getResource("../fxml/addModal.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// FXML로 만든 자식창의 컨트롤을 부모가 만들어주기
		TextField nameField = (TextField) parent.lookup("#tname");
		TextField koreaField = (TextField) parent.lookup("#tkorean");
		TextField mathField = (TextField) parent.lookup("#tmath");
		TextField englishField = (TextField) parent.lookup("#tenglish");
		
		Button saveButton = (Button) parent.lookup("#savebtn");
		Button cancelButton = (Button) parent.lookup("#cancelbtn");
		
		// 5. Scene 객체 생성해서 컨테이너 객체 추가
		
		
		Scene scene = new Scene(parent);
		// 6. Stage 객체에 Scene 객체 추가
		addStudentDiaglog.setScene(scene);
		addStudentDiaglog.setResizable(false);//크기 고정
		addStudentDiaglog.showAndWait();
	
		recordsData = DataShare.recordsList;
		tv.setItems(recordsData);
			

	}// addStudent

	

}
