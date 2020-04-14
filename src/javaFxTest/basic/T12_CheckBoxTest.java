package javaFxTest.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class T12_CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rect = new Rectangle(90, 30);//4각형 그리기
		rect.setArcHeight(10); // 둥근 4각형 만들기 위한 꼭지점 모따기(둥글게)
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41)); // 4각형 내부 색칠하기
		
		String[] names = new String[] {"Security", "Project", "Chart"};
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];// Image와 같이 다닌다.
		
		CheckBox[] chkboxs = new CheckBox[names.length];
		
		for (int i = 0; i < names.length; i++) {
			// 출력할 이미지 읽어오기
			final Image img = images[i] = new Image(getClass().getResourceAsStream("images/" + names[i] + ".png")); 
			//getClass(객체인데 현재 클래스 정보로 찾겠다(현재 패키지를 기준으로 무언가를 찾고 싶을 때 getClass를 사용한다.)) => T12_CheckBoxTest의 정보
			//getResourceAsStream : 리소스를 가져오는데 스트림 타입(형태)으로 가져온다.
			
			// 이미지를 출력하는 객체 생성
			final ImageView icon = icons[i] = new ImageView();
			final CheckBox cb = chkboxs[i] = new CheckBox(names[i]);
			
			// CheckBox 를 클릭해서 값이 변경되었을 때의 이벤트 처리
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {//selectedProperty().addListener
				// addListener : 새로운 메소드를 등록하기 위해서 사용한다.

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(newValue == true) {
						icon.setImage(img); // ImageView에서 setImage()라는 메소드를 가져와서 화면에 이미지를 넣어서 나한테 보여주는 역할
					}else {
						icon.setImage(null);// ImageView 에서 이미지 삭제
					}
					
				}
			}); // CheckBox 를 클릭해서 값이 변경되었을 때의 이벤트 처리
			
			
	
		}// for
		Button btnOk = new Button("확인");
		btnOk.setOnAction(e -> { // 람다식으로 바꿈
			// CheckBox의 check여부를 확인하는 방법
			if(chkboxs[1].isSelected()) {
				showInfo(chkboxs[1].getText() + "체크");
			}else {
				showInfo(chkboxs[1].getText() + "체크해제");
			}
			
			// CheckBox의 check 여부 셋팅하기
			// chkboxs[0].setSelected(true); // 체크하기
			// chkboxs[0].setSelected(false); // 해제하기
			chkboxs[0].setSelected(!chkboxs[1].isSelected()); //setSelected : 체크해주는 메소드
			
			
		});//btnOk
		
		VBox vBox = new VBox(5);// 인수는 spacing을 주는 것이다.
		vBox.getChildren().addAll(chkboxs);
		vBox.getChildren().add(btnOk);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons); // 아이콘들을 추가함 //getChildren 은 obserble로 관리함
		hbox.setPadding(new Insets(0, 0, 0, 5)); // left만 5라는 패딩을 줌
		
		// StackPane은 컨트롤들을 쌓아놓는 방식으로 배치하는
		// 컨테이너이다.
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect,hbox); // 아이콘들이 stack 형태로 들어간다.
		StackPane.setAlignment(rect, Pos.TOP_CENTER); 
		
		HBox root = new HBox();
		root.setSpacing(40);
		root.setPadding(new Insets(20, 10, 10, 20));
		root.getChildren().addAll(vBox,stack);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("CheckBox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
		
		
	}// start

	
	private void showInfo(String msg) {
		Alert alertInfo  = new Alert(AlertType.INFORMATION);
		alertInfo.setTitle("INFORMATION");
		alertInfo.setContentText(msg);
		alertInfo.showAndWait();
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}// main
}
