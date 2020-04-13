package javaFxTest.basic.scenebuilder;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class ComboGugudanController implements Initializable {

	@FXML
	private ComboBox<Integer> cmbDan;
	@FXML
	private Button btnDan;
	@FXML
	private TextArea txtResult;

	// fxml 이 들어가면 fxml loader이 만들고 controller이 만듬 fx loader이 만듬
//	자바 로더가 어노테이션FXML이 붙은 애들을 찾아서 올려준다?

	@Override
	public void initialize(URL location, ResourceBundle resources) { // 초기화할 내용 작성
		
		// 널이 아니면 안되 객체 주입이 제대로 안 일어남 assert가 발생함. 예외를 알려주는 것
		// 기본적으로 체크를 안함 주석과 같다고 생각. 하지만 실행을 했을 때 사용해서 체크를 해볼때 활성화 시킬수도 있고 안시킬 수 도 있다.
		assert cmbDan != null : "fx:id\"cmbDan\" was not injected: check your FXML file 'ComboGugudan.fxml.";
		// assert 는 객체가 잘 주입되엇는지 확인하는 용도이다. 
		assert txtResult != null : "fx:id\"txtResult\" was not injected: check your FXML file 'ComboGugudan.fxml.";
		
		assert btnDan != null : "fx:id\"btnDan\" was not injected: check your FXML file 'ComboGugudan.fxml.";
		
		ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		cmbDan.setItems(list);
/*
		btnDan.setOnAction(e -> {
//			int dan = cmbDan.getSelectionModel().getSelectedItem();
			int dan = cmbDan.getValue(); // 이렇게도 되고 위에처럼도 되고

			txtResult.setText(dan + "단\n\n");
			for (int i = 0; i <= 9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");

			}
		});
		*/
	}// initialize

	@FXML public void btnDanClicked(ActionEvent event) {
//		int dan = cmbDan.getSelectionModel().getSelectedItem();
		/*int dan = cmbDan.getValue(); // 이렇게도 되고 위에처럼도 되고

		txtResult.setText(dan + "단\n\n");
		for (int i = 0; i <= 9; i++) {
			int r = dan * i;
			txtResult.appendText(dan + " * " + i + " = " + r + "\n");

		}*/
	}
}// ComboGugudanController
