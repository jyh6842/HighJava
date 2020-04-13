package javaFxTest.basic.scenebuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComboGugudanMain extends Application{
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ComboGugudan.fxml"));
		
		Scene scene = new Scene(root);
			primaryStage.setTitle("콤보박스 구구단");
			primaryStage.setScene(scene);
			primaryStage.show();
		}

		
	
}
