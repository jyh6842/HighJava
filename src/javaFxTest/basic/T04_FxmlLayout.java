package javaFxTest.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//FxmlLayout.fxml 와 연결되어 있다.
public class T04_FxmlLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// fxml 파일을 읽어와 현재 State에 적용하기
		// 방법1
		// 우리가 만든 Fxml은 가장 바깥에 있는 창이 HBox 이다.
		/*
		Parent root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
		*/
		
		// 방법2 : 이렇게 쓰면 인스턴스를 만드는 것이기 때문에 더 많은 유용한 파일들을 쓸 수 있다.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
		Parent root = loader.load();
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Fxml 문서를 이용한 레이아웃 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
