package javaFxTest.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T13_RadioButtonTest extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 라디오버튼을 묶음으로 처리할 객체 생성
		
		ToggleGroup group = new ToggleGroup();
		
		ImageView icon = new ImageView();
		
		RadioButton rb1 = new RadioButton("HOME");
//		rb1.setText("HOME"); rb1.setUserData와 같다.
		rb1.setToggleGroup(group); //라디오 버튼을 그룹에 추가
		rb1.setUserData("Home"); // 선택했을 때의 값을 나타내기 위한 데이터 //setUserData : 라디오 버튼에 Home이라는 데이터를 선택해 놓는다.
		
		RadioButton rb2 = new RadioButton("CALENDAR");
		rb2.setToggleGroup(group);
		rb2.setUserData("Calendar"); // 이게 있어야 데이터가 등록되고 이미지가 변경될 수 있도록 등록해주는 역할?
		
		RadioButton rb3 = new RadioButton("CONTACTS");
		rb3.setToggleGroup(group);
		rb3.setUserData("Contacts");
		
		// 그룹 내에서 RadioButton 중 하나가 선택되었을때 처리하기
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// 선택한 항목(라디오 버튼)이 있는지 검사
				
				if(newValue.getUserData() != null) { // 2가지 방법
//				if(group.getSelectedToggle().getUserData() != null) { // 선택되어 있는 값을 가져온다. 
					String url = group.getSelectedToggle().getUserData().toString();
					
					Image image = new Image(getClass().getResourceAsStream("images/" + url + ".jpg"));
					icon.setImage(image); // 이미지 뷰에 이미지를 넣어야 이미지가 우리에게 보인다.
				}
			}
		});
		
		rb1.setSelected(true); // 선택된 상태로 설정
		
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		
		vbox.getChildren().addAll(rb1, rb2, rb3);
		vbox.setSpacing(10);
		
		hbox.getChildren().addAll(vbox, icon);
		hbox.setSpacing(50);
		hbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(hbox, 250, 150); // 넓이와 높이
		
		primaryStage.setTitle("라디오버튼 예제");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
