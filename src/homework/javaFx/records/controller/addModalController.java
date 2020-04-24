package homework.javaFx.records.controller;

import java.net.URL;
import java.util.ResourceBundle;

import homework.javaFx.records.util.DataShare;
import homework.javaFx.records.vo.recordsVO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addModalController implements Initializable {

	@FXML private Button savebtn;
	@FXML private Button cancelbtn;
	
	@FXML private TextField tname;
	@FXML private TextField tkorean;
	@FXML private TextField tmath;
	@FXML private TextField tenglish;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		// 생각해본 방법 
		// 1. 부모에 접근해서 그 신을 가져온 후에 부모의 요소에 접근하겠다.
		// 2. 데이터 베이스에 접근해서 값을 집어 넣는다.
		// => 부모로 접근해 보고 싶다.
		
		
		
		
		savebtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DataShare.recordsList.add(new recordsVO(tname.getText(), Integer.parseInt(tkorean.getText()), Integer.parseInt(tmath.getText()), Integer.parseInt(tenglish.getText())));
				Stage stage = (Stage) savebtn.getScene().getWindow();
				stage.close();
			}
		});
		
		cancelbtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) cancelbtn.getScene().getWindow();
				stage.close();
				
		
				
			}
		});
	}
	
	
}
