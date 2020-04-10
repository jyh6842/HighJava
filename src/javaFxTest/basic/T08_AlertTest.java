package javaFxTest.basic;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class T08_AlertTest extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception {
      Alert alertInfo = new Alert(AlertType.INFORMATION);
      alertInfo.setTitle("INFORMATION");
      alertInfo.setContentText("INFORMATION Alert 창 입니다.");
      alertInfo.showAndWait(); //Alert창 보이기
      //======================================================
      
      Alert alertErr = new Alert(AlertType.ERROR);
      alertErr.setTitle("ERROR");
      alertErr.setContentText("ERROR Alert 창 입니다.");
      alertErr.showAndWait(); //Alert창 보이기
      //======================================================
      
      Alert alertWarn = new Alert(AlertType.WARNING);
      alertWarn.setTitle("WARNING");
      alertWarn.setContentText("WARNING Alert 창 입니다.");
      alertWarn.showAndWait(); //Alert창 보이기
      //======================================================
      
      Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
      alertConfirm.setTitle("CONFIRMATION");
      alertConfirm.setContentText("CONFIRMATION Alert창 입니다.");
      
      //Alert창을 보여주고 사용자가 누른 버튼 값 가져오기
      ButtonType confirmResult = alertConfirm.showAndWait().get();
      
      if(confirmResult == ButtonType.OK) {
         System.out.println("OK 버튼 눌렀습니다.");
      }else if(confirmResult == ButtonType.CANCEL) {
         System.out.println("취소 버튼을 눌렀습니다.");
      }
      
      //=========================================================
      
      //Javascript의 prompt창과 같은 기능
      //'기본 값'은 생략 가능
      TextInputDialog dialog = new TextInputDialog("기본값");
      
      dialog.setTitle("Prompt창"); //창제목
      dialog.setHeaderText("TextInputDialog창 입니다.");
      
      //창을 보이고 입력한 값을 읽어오기
      Optional<String> result = dialog.showAndWait(); // Optional 자바에서 제공해주는 타입임 javafx에서 제공하는 타입
      String strResult = null; //입력한 값이 저장될 변수
      
      //입력한 값이 있는지 검사 (값 입력 후 'OK'버튼 눌렀는지 검사)
      if(result.isPresent()) {
         strResult = result.get(); //값 읽어오기
      }
      System.out.println("읽어온 값: "+strResult);
      
   }
   
   public static void main(String[] args) {
      launch(args);
   }

}