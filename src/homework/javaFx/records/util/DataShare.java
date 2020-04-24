package homework.javaFx.records.util;

import homework.javaFx.records.vo.recordsVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataShare {
	public static ObservableList<recordsVO> recordsList = FXCollections.observableArrayList();
	static {
		recordsList.add(new recordsVO("홍길동A", 40, 60, 80));
		recordsList.add(new recordsVO("홍길동B", 60, 80, 40));
		recordsList.add(new recordsVO("홍길동C", 80, 40, 60));
	}
}
