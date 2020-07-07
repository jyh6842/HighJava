package homework.javaFx.records.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.undo.StateEdit;

import homework.javaFx.records.util.DataShare;
import homework.javaFx.records.vo.recordsVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RecordsMainController implements Initializable {

	@FXML
	private TableView<recordsVO> tv;
	@FXML
	private TableColumn<recordsVO, String> colname;
	@FXML
	private TableColumn<recordsVO, Integer> colkorean;
	@FXML
	private TableColumn<recordsVO, Integer> colmath;
	@FXML
	private TableColumn<recordsVO, Integer> colenglish;

	@FXML
	Button btn_graph;

	private ObservableList<recordsVO> recordsData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		colname.setCellValueFactory(new PropertyValueFactory<recordsVO, String>("name"));
		colkorean.setCellValueFactory(new PropertyValueFactory<recordsVO, Integer>("kor"));
		colmath.setCellValueFactory(new PropertyValueFactory<recordsVO, Integer>("math"));
		colenglish.setCellValueFactory(new PropertyValueFactory<recordsVO, Integer>("eng"));

		recordsData = FXCollections.observableArrayList();

		recordsData = DataShare.recordsList;

		tv.setItems(recordsData);

	}

	@FXML
	public void addStudent(MouseEvent event) {
		// 새창을 띄우자

		// 1. Stage 객체 생성
		Stage addStudentDiaglog = new Stage(StageStyle.UTILITY);

		// 2. 모달창 여부 설정
		// 모달창은 자식창이 나타나면 부모창을 사용할 수 없다. // 다른거 활성화 못시키게 막아버리기
		addStudentDiaglog.initModality(Modality.APPLICATION_MODAL);

		// 3. 부모창 지정
		addStudentDiaglog.initOwner(tv.getScene().getWindow());

		addStudentDiaglog.setTitle("학생의 성적 추가");

		// 4. 자식창에 나타날 컨테이너 설정
		Parent parent = null;

		try {
			parent = new FXMLLoader().load(getClass().getResource("../fxml/addModal.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// FXML로 만든 자식창의 컨트롤을 부모가 만들어주기
		TextField nameField = (TextField) parent.lookup("#tname"
				);
		TextField koreaField = (TextField) parent.lookup("#tkorean");
		TextField mathField = (TextField) parent.lookup("#tmath");
		TextField englishField = (TextField) parent.lookup("#tenglish");

		Button saveButton = (Button) parent.lookup("#savebtn");
		Button cancelButton = (Button) parent.lookup("#cancelbtn");

		// 5. Scene 객체 생성해서 컨테이너 객체 추가

		Scene scene = new Scene(parent);
		// 6. Stage 객체에 Scene 객체 추가
		addStudentDiaglog.setScene(scene);
		addStudentDiaglog.setResizable(false);// 크기 고정
		addStudentDiaglog.showAndWait();

		recordsData = DataShare.recordsList;
		tv.setItems(recordsData);

	}// addStudent

	@FXML
	public void graph_show(MouseEvent event) { // bar
		Stage stage = new Stage();

		CategoryAxis xAxis = new CategoryAxis();

		NumberAxis yAxis = new NumberAxis();

		BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);

		XYChart.Series<String, Number> kor = new XYChart.Series<String, Number>();
		ObservableList<XYChart.Data<String, Number>> korList = FXCollections.observableArrayList();
		for (recordsVO subjectList : DataShare.recordsList) {

			korList.add(new XYChart.Data<String, Number>(subjectList.getName(), subjectList.getKor()));
		}
		kor.setName("국어");
		kor.setData(korList);
		XYChart.Series<String, Number> math = new XYChart.Series<String, Number>();
		ObservableList<XYChart.Data<String, Number>> mathList = FXCollections.observableArrayList();
		for (recordsVO subjectList : DataShare.recordsList) {

			mathList.add(new XYChart.Data<String, Number>(subjectList.getName(), subjectList.getMath()));

		}
		math.setName("수학");
		math.setData(mathList);
		XYChart.Series<String, Number> eng = new XYChart.Series<String, Number>();
		ObservableList<XYChart.Data<String, Number>> engList = FXCollections.observableArrayList(); // 메인 창이 아니기 때문에
																									// 켤때마다 초기화 된다고 생각하자
		for (recordsVO subjectList : DataShare.recordsList) {

			engList.add(new XYChart.Data<String, Number>(subjectList.getName(), subjectList.getEng()));

		}
		eng.setName("영어");
		eng.setData(engList);

		bc.getData().addAll(kor, math, eng);

		Scene scene = new Scene(bc, 600, 600);

		stage.setTitle("바 차트");
		stage.setScene(scene);
		stage.show();

		tv.setOnMouseClicked(e -> {
			
			
			
			
			recordsVO rVO = tv.getSelectionModel().getSelectedItem();

			// piechart
			Stage stage2 = new Stage();

			PieChart pieChart = new PieChart();

			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
			pieChartData.add(new PieChart.Data("국어", rVO.getKor()));
			pieChartData.add(new PieChart.Data("수학", rVO.getMath()));
			pieChartData.add(new PieChart.Data("영어", rVO.getEng()));

			pieChart.setTitle("파이 그래프");
			pieChart.setLabelLineLength(100);
			pieChart.setLegendSide(Side.BOTTOM);
			pieChart.setData(pieChartData);

			Scene scene2 = new Scene(pieChart, 500, 500);
			stage2.setTitle("PieChar 연습");
			stage2.setScene(scene2);
			stage2.show();
		});

	}

}
