package homework.javaFx.records.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RecordsController implements Initializable{

	@FXML private TableView tv;
	@FXML private TableColumn colname;
	@FXML private TableColumn colkorean;
	@FXML private TableColumn colmath;
	@FXML private TableColumn colenglish;
	@FXML private Button btn_add;
	@FXML private Button btn_graph;
	//////////////////////////////////////////////////////////////////////////////////// 추가창

	////////

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		btn_add.setOnAction(e->{
			
			
		});
		
	}

}
