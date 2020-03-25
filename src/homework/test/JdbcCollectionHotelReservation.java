package homework.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JdbcCollectionHotelReservation {
	Scanner sc = new Scanner(System.in);
	Map<String, String> roomMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		new JdbcCollectionHotelReservation().menu();
		
	}// main

	public void menu() {
		while (true) {
			

			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");

			System.out.print("메뉴선택 >> ");
			int selectMenuNum = Integer.parseInt(sc.nextLine());

			switch (selectMenuNum) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				EnterpriseCheckRoom();
				break;
			case 4:
				System.out.println("업무를 종료하겠습니다.");
				if (selectMenuNum == 4) {
					break;
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}

			
		} // while
	}

	private void EnterpriseCheckRoom() {
		Set<String> keySet = roomMap.keySet();
		for(String key  : keySet) {
			System.out.println("방번호 : " +key+ "투숙객 : " + roomMap.get(key));
		}

	}

	private void checkOut() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 =>");
		String roomNum = sc.nextLine();
		if (!roomMap.containsKey(roomNum)) { // 방에 사람이 있으면 break;
			System.out.println("방을 잘못 입력하셨습니다.");
			return;
		}
		roomMap.remove(roomNum);

	}

	private void checkIn() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB에 접속
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "jyh6842";
			String password = "java";

			// OracleDriver 을 실제적으로 사용하는 부분
			conn = DriverManager.getConnection(url, userId, password);

			// 3. Statement 객체 생성 => Connection 객체를 이용한다.
			stmt = conn.createStatement(); // Statement 쿼리를 날려주는 역할

			// 4. SQL 문을 Statement 객체를 이용하여 실행하고
			// 실행 결과를 ResultSet 객체에 저장한다.
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 =>");
			String roomNum = sc.nextLine();
			String sql = "SELECT * FROM hotel WHERE roomNum ='"+roomNum+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("이미 예약된 방입니다.");
				return; 
			}
			System.out.print("이름을 입력해주세요 >>");
			String roomGesut = sc.nextLine();
			sql = "INSERT INTO hotel values('"+roomNum+"','"+roomGesut+"')";
			int num = stmt.executeUpdate(sql);
			System.out.println(num + "행이 삽입되었습니다.");
			
			/*
			 CREATE table hotel(
    		roomNum NUMBER(4) primary Key,
    		roomGesut VARCHAR(15)
			);

			commit;

			select * from hotel;

			 */
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}// JdbcCollectionHotelReservation


