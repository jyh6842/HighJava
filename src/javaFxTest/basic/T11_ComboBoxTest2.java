package javaFxTest.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T11_ComboBoxTest2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vbox = new VBox(10);
		ComboBox<MyFriend> combo = new ComboBox<>();
		TextArea result = new TextArea();
		
		ObservableList<MyFriend> list = 
			FXCollections.observableArrayList(
				new MyFriend("a001", "홍길동", "1111", "대전"),
				new MyFriend("a002", "이순신", "2222", "대구"),
				new MyFriend("a003", "강감찬", "3333", "부산"),
				new MyFriend("a004", "성춘향", "4444", "광주"),
				new MyFriend("a005", "이몽룡", "5555", "목포"),
				new MyFriend("a006", "변학도", "6666", "서울")
			);
		combo.setItems(list);
		
		// ComboBox의 목록이 보여지는 곳의 내용 변경하기
		// 화면에 나타나는 셀의 내용을 변경하는 부분으로 
		// 이 부분의 변경내용은 셀부분만 변경된다.
/////		
		combo.setCellFactory(new Callback<ListView<MyFriend>,  // 이게 중요? 이게 머하는건데?
								ListCell<MyFriend>>() { // 객체가 주소로 보이는데 이것을 글자로 바꿔주는 역할을 하는 부분이다.
								// 하나하나의 셀들이다. 홍길동만 색깔이 다른데 UI 가
			
			@Override
			public ListCell<MyFriend> call(ListView<MyFriend> param) {
				// TODO Auto-generated method stub
				return new ListCell<MyFriend>() {
					protected void updateItem(MyFriend item,  //각각의 셀을 만들어줌
												boolean empty) {
						super.updateItem(item, empty); // ??? 이걸 왜 하는 거지? // 원래 셀을 만드는 역할을 하던 애임 꼭 있어야 함
						if(item == null || empty) { 
							setText(null); // 여기가 코딩해 주는 부분 값이 있으면 else로
						}else {
							// 변경된 값이 문자열이면 setText()
							// 객체이면 setGraphic()메서드로 변경한다.
							setText(item.getName()); // 이름으로 셋팅
						}
					}
				};
			}
		});
/////		
		// ComboBox에서 리스트 항목을 선택하면 선택된 내용이 
		// ComboBox의 '버튼영역'에 나타나는데
		// 이 부분의 내용도 변경해 주어야 한다.
		combo.setButtonCell(new ListCell<MyFriend>() { //buttonCell 이 친구 없으면 button이 없으면 객체 정보가 그대로 노출
			protected void updateItem(MyFriend item, boolean empty) { //updateItem 커스텀 했다.
				super.updateItem(item, empty);
				if(empty) {
					setText(null);
				}else {
					setText(item.getName());
				}
			}
		});
		
		combo.setValue(list.get(0));
		
		// ComboBox를 setOnAction 처리하기
/*		
		combo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 현재 선택한 데이터 구하기
				MyFriend data =
					combo.getSelectionModel().getSelectedItem();
				
				result.setText(data.getId() + "\n");
				result.appendText(data.getName() + "\n");
				result.appendText(data.getTel() + "\n");
				result.appendText(data.getAddr() + "\n");
			}
		});
*/
//		combo.valueProperty().add
		// 차이점은 요런 정보들을 호출 할때 불러줌 이게 더 많이 불러옴
		
		vbox.getChildren().addAll(combo, result);
		vbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(vbox, 400, 300);
		primaryStage.setTitle("콤보박스에 객체 데이터 설정");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// 데이터를 나타내는 클래스를 Inner클래스로 선언함.
	class MyFriend {
		
		private String id;
		private String name;
		private String tel;
		private String addr;
		
		public MyFriend(String id, String name, String tel, String addr) {
			super();
			this.id = id;
			this.name = name;
			this.tel = tel;
			this.addr = addr;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}
	}
}
