package homework.javaFx.member;

import java.net.URL;
import java.util.ResourceBundle;

import javaFxTest.basic.T15_TableViewTest.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberController implements Initializable {

	@FXML
	private TextField textid;
	@FXML
	private TextField textname;
	@FXML
	private TextField texttel;
	@FXML
	private TextField textaddr;
	@FXML
	private Button btnadd;
	@FXML
	private Button btnedit;
	@FXML
	private Button btndel;
	@FXML
	private Button btnok;
	@FXML
	private Button btncancel;
	@FXML
	private TableView<MemberVO> membertableview;
	@FXML
	private TableColumn<MemberVO, String> colid;
	@FXML
	private TableColumn<MemberVO, String> colname;
	@FXML
	private TableColumn<MemberVO, String> coltel;
	@FXML
	private TableColumn<MemberVO, String> coladdr;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<MemberVO> data = FXCollections.observableArrayList();

		membertableview.setItems(data);

		colid.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("id")); // 뒤에 id 가 vo
		colname.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("name"));
		coltel.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("tel"));
		coladdr.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("addr"));

		btnadd.setOnAction(e -> {
			if (textid.getText().isEmpty() || textname.getText().isEmpty() || texttel.getText().isEmpty()
					|| textaddr.getText().isEmpty()) {
				errMsg("빈칸을 확인", "빈칸을 채우세요");
				return;
			}

			data.add(new MemberVO(textid.getText(), textname.getText(), texttel.getText(), textaddr.getText()));

			infoMsg("작업결과", textid.getText() + "님 정보를 추가 성공~");
		});// btnadd

		btnedit.setOnAction(e -> {
			if (textid.getText().isEmpty() || textname.getText().isEmpty() || texttel.getText().isEmpty()
					|| textaddr.getText().isEmpty()) {
				errMsg("빈칸을 확인", "빈칸을 채우세요");
				return;
			}

			data.set(membertableview.getSelectionModel().getSelectedIndex(),
					new MemberVO(textid.getText(), textname.getText(), texttel.getText(), textaddr.getText()));
		});

	}

	private void infoMsg(String string, String string2) {
		Alert okAlert = new Alert(AlertType.INFORMATION);
		okAlert.setTitle("입력 성공~");
		okAlert.setHeaderText(string);
		okAlert.setContentText(string2);
		okAlert.show();
	}

	private void errMsg(String string, String string2) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류 발생!!");
		errAlert.setHeaderText(string);
		errAlert.setContentText(string2);
		errAlert.showAndWait();
	}

}
