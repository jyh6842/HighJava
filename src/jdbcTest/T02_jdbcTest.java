package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02_jdbcTest {
	/*
		문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다_id가 큰 자료들을 출력하시오.
		
		문제2) lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터 큰값 사이의 자료를 출력하시오.
	*/
	
	public static void main(String[] args) {
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
			
			//OracleDriver 을 실제적으로 사용하는 부분
			conn = DriverManager.getConnection(url, userId, password);
			
			// 3. Statement 객체 생성 => Connection 객체를 이용한다.
			stmt = conn.createStatement(); // Statement 쿼리를 날려주는 역할
			
			// 4. SQL 문을 Statement 객체를 이용하여 실행하고
			// 실행 결과를 ResultSet 객체에 저장한다.
			
			Scanner sc = new Scanner(System.in);
			System.out.println("id 를 입력해주세요, 아이디는 숫자");
			int findId1 = Integer.parseInt(sc.nextLine());
			T02_jdbcTest test = new T02_jdbcTest();
			String sql = test.selectId(findId1);
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("=== 쿼리문 실행 결과 ===");
			
			// rs.next() => ResultSet 객체의 데이터를 가리키는 포인터를 
			//				다음 레코드로 이동시키고 그곳에 자료가 있으면
			//				true, 없으면 false를 반환한다.
			while(rs.next()) {
				// 컬럼의 자료를 가져오는 방법
				// 방법1) rs.get자료형 이름("컬럼명")
				// 방법2) rs.get자료형이름(컬럼번호) => 컬럼번호는 1번부터 시작
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("------------------------------------------------");
			}
			System.out.println("출력 끝");
			
			System.out.println("사이값 출력하기");
			System.out.println("전에 입력했던 id와 이번에 입력하는 아이디 사이의 값입니다.아이디는 숫자. 숫자를 입력해주세요.");
			int findId2 = Integer.parseInt(sc.nextLine());
			sql = test.betweenId(findId1, findId2);
			rs = stmt.executeQuery(sql);
			
			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("=== 쿼리문 실행 결과 ===");
			while(rs.next()) {
				// 컬럼의 자료를 가져오는 방법
				// 방법1) rs.get자료형 이름("컬럼명")
				// 방법2) rs.get자료형이름(컬럼번호) => 컬럼번호는 1번부터 시작
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("------------------------------------------------");
			}
			System.out.println("출력 끝");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 종료 ( 사용했던 자원을 모두 반납한다.)
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
	public String selectId(int id) {
		String sql = "SELECT * FROM lprod WHERE lprod_id >'"+id+"'";
		return sql;
	}
	
	public String betweenId(int id1, int id2) {
		int temp = id1;
		if(id1 > id2) {
			temp = id1;
			id1 = id2;
			id2 = temp;
		}
		String sql = "SELECT * FROM lprod WHERE lprod_id > '"+id1+"'AND lprod_id < '"+id2+"'";
		return sql;
	}
}
