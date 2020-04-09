package homework.javaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Fx_controlObject extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(); //컨트롤들을 세로로 배치해 주는 컨테이너
		root.setPrefWidth(650); // VBox의 너비
		root.setPrefHeight(300); // VBox의 높이
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.TOP_LEFT); 
		root.setSpacing(10); // 컨트롤과 컨트롤 사이의 간격
		
		HBox nameHBox = new HBox();
		Label nameLabel = new Label();
		nameLabel.setText("이  름 : ");
		nameLabel.setFont(new Font(10));
		TextField nameTextField = new TextField();
		nameHBox.getChildren().addAll(nameLabel,nameTextField);
		
		HBox genderHBox = new HBox();
		ToggleGroup group = new ToggleGroup();
        RadioButton btn1 = new RadioButton("Male");
        btn1.setToggleGroup(group);
        btn1.setSelected(true);
        RadioButton btn2 = new RadioButton("Female");
        btn2.setToggleGroup(group);
        genderHBox.getChildren().addAll(btn1, btn2);
        
//		HBox hobyHBox = new HBox(root);
//		HBox buttionHBox = new HBox(root);
//		HBox textFieldHBox = new HBox(root);
		
		root.getChildren().addAll(nameHBox, genderHBox);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("박스");// 창 제목
		primaryStage.setScene(scene); // Stage 에 Scene 설정
		primaryStage.show(); // 창(Stage) 보이기
		
		
		
		
		


	}
}
