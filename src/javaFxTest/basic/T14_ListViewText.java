package javaFxTest.basic;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T14_ListViewText extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<String>();

		Label label = new Label();
		label.setFont(new Font(20));

		// ListView에 들어갈 데이터 구성하기
		ObservableList<String> data = FXCollections.observableArrayList("green", "gold", "red", "blue", "black",
				"brown", "blueviolet", "pink", "yellow", "chocolate"); 
		list.setItems(data);
		
		// ex)
//		 List<String> strList = new ArrayList<String>();
//		 strList.add("green");
//		 strList.add("red");
//		 strList.add("gold");
//		 ObservableList<String> data2 = FXCollections.observableArrayList(strList);
//		 list.setItems(data2);

		// ListView에서 값이 선택되었을 때 처리
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue); // console에서 확인해 보려고
				label.setText(newValue); // 이게 있어야 밑에 글씨가 나온다.
				label.setTextFill(Color.web(newValue));
			}

		});

		// listView의 내용은 변경되지 않고 화면에 보이는 부분만 변경하기
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {
					protected void updateItem(String item, boolean empty) { // item : blue, black 등등 ObservableList에 넣은 것
						super.updateItem(item, empty);

						// 변경되는 데이터가 문자열이면 setText()
						// 변경되는 데이터가 그래픽이면 setGrapic() 사용

//						setText(item); // 밑에거 빼면 색이 빠짐 이건 색이 빠진걸 확인하기 위해서 써 놓은 것임
						Rectangle rect = new Rectangle(100, 20);
						if (item != null) {
							rect.setFill(Color.web(item)); // 4 각형 색칠하기

							Label lblTxt = new Label(item);
							lblTxt.setTextFill(Color.web(item));

							HBox hb2 = new HBox();
							hb2.getChildren().addAll(rect, lblTxt,
									new ImageView(new Image(getClass().getResourceAsStream("images/Security.png"))));
							setGraphic(hb2); // 그래픽요소 값을 넣고 싶으면 setGraphic을 넣으면 된다. 파라미터는 Node(fx에서 만들 수 있는 객체)  
						}

					}
				};// ListCell
			}
		});// call

		VBox vbox = new VBox(10);

		vbox.getChildren().addAll(list, label);

		Scene scene = new Scene(vbox);
		primaryStage.setTitle("ListView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
