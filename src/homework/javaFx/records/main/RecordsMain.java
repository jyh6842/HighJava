package homework.javaFx.records.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecordsMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
    @Override
    public void start(Stage primaryStage) {
        try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/recodrsMain.fxml"));
			Parent parent = loader.load();

			Scene scene = new Scene(parent);
			primaryStage.setTitle("성적관리");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
