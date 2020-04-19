package homework.javaFx.records.main;

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
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/recordsMain.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        primaryStage.setTitle("성적관리");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
}
