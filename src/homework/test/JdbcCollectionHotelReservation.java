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
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
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
		try {
			// 1. 드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB 접속(연결) 연결되면 연결객체를 얻는다. 또한 접속을 위한 아이디와 비밀번호를 받는다.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "jyh6842", "java");
				
			// 3. 연결되면 SQL 문을 실행하기 위한 객체를 만든다.Statement 이고 연결을 위해서 위에서 사용하였던 connection 객체를 사용한다.
				stmt = conn.createStatement();
				
			// 4. sql문을 작성하고 Statement객체.executeQuery(sql)이나 .exectueUpdate(sql)문을 사용하여 sql문을 실행한다.
				String sql = "SELECT * FROM hotel";
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					System.out.print(rs.getInt("roomNum"));
					System.out.println(rs.getString("roomGesut"));
				}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		


	}

	private void checkOut() {
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB에 접속(DB에 연결)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "jyh6842", "java");
			
			// 3. Statement 객체 생성 => Connection 객체를 이용한다.
			stmt = conn.createStatement();
			
			// 4. SQL문 작성 및 Statement 문을 실행한다.
			System.out.println("몇번 방을 체크하웃하시겠습니까?");
			int roomNum = Integer.parseInt(sc.nextLine());
			String sql = "DELETE FROM hotel WHERE roomNum = '"+roomNum+"'";
			
			int cnt = stmt.executeUpdate(sql);
			
			if(cnt>0) {
				System.out.println(roomNum + " 방이 체크아웃 되었습니다.");
			}else {
				System.out.println(roomNum + " 방이 체크아웃에 실패했습니다.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkIn() {

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
			int roomNum = Integer.parseInt(sc.nextLine());
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


