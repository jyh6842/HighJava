package javaFxTest.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T10_ComboGugudanMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root= new BorderPane();
		root.setPrefSize(300, 300);
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextArea txtResult = new TextArea();
		txtResult.setPrefSize(200, 200);
		
		Button btnDan = new Button("출력");
		
		ComboBox<Integer> cmbDan = new ComboBox<Integer>();
		cmbDan.setPrefWidth(150);
		
		ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
		cmbDan.setItems(list);
		
		btnDan.setOnAction(e->{
//			int dan = cmbDan.getSelectionModel().getSelectedItem();
			int dan = cmbDan.getValue(); // 이렇게도 되고 위에처럼도 되고
			
			txtResult.setText(dan + "단\n\n");
			for (int i = 0; i <= 9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i +" = " + r  + "\n");
				
			}
		});
		
		hbox.getChildren().addAll(cmbDan, btnDan);
		
		root.setTop(hbox);
		root.setCenter(txtResult);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("콤보박스 구구단");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
