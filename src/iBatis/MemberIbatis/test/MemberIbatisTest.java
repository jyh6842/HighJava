package iBatis.MemberIbatis.test;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import iBatis.MemberVO;



public class MemberIbatisTest {

	public static void main(String[] args) {
		// ibatis를 이용하여 DB 자료를 처리하는 작업 순서
		// 1. ibatis의 환경 설정 파일을 읽어와 실행시킨다.
		try {
			// 1-1. xml 문서 읽어오기
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			//1-2. 위에서 읽어온 Reader 객체를 이용하여 실제 작업을 진행할 객체 생성
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // Reader 객체 닫기
			
			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			// 2-1. insert 작업 연습
			System.out.println("insert 작업 시작...");
			
			//1) 저장할 데이터를 VO에 담는다.
			MemberVO mv = new MemberVO();
			mv.setMem_id("d001");
			mv.setMem_name("강감찬");
			mv.setMem_tel("010-1111-1111");
			mv.setMem_addr("대전시 중구 대흥동");
			
			//2)sqlMapClient 객체 변수를 이용하여 해당 쿼리문을 실행한다.
			// 형식) smc.insert("namespace값.id값", 파리미터클래스);
			// 				반환값: 성공하면 null 이 반환된다.
			Object obj = smc.insert("memberTest.insertMember", mv);
			if(obj == null) {
				System.out.println("insert 작업 성공");
			}else {
				System.out.println("insert 작업 실패");
			}
			
			// 2-2 update 작업 연습
			System.out.println("update 작업 시작...");
			
			MemberVO mv2 = new MemberVO();
			mv2.setMem_id("d001");
			mv2.setMem_name("이순신");
			mv2.setMem_tel("9999-9999");
			mv2.setMem_addr("서울시 강남구 대치동");
			
			// update() 메서드의 반환값 => 성공한 레코드 수
			int cnt = smc.update("memberTest.updateMember", mv2);
			if (cnt > 0) {
				System.out.println("udpate 작업 성공");
			}else {
				System.out.println("update 작업 실패!!");
			}
			
			// 2-3 delete 연습
			System.out.println("delete 작업 시작...");
			
			// delete에서의 반환값 : 성공한 레코드 수
			int cnt2 = smc.delete("memberTest.deleteMember", "d001");
			if(cnt2 > 0 ) {
				System.out.println("delete 작업 성공");
			}else {
				System.out.println("delete 작성 실패");
			}
			
			
			// 2-4 select 연습
			// 1) 응답의 결과 여러개인 경우
			System.out.println("select 연습 시작(결과가 여러개인 경우)...");
			List<MemberVO> memList;
			
			// 응답의 결과가 여러개일 경우네는 queryForList 메서드를 이용한다.
			// 이메서드는 여러개의 레코드를 VO에 담은 후 이 VO 데이터를
			// List 에 추가해 주는 작업을 자동으로 수행한다.
			memList = smc.queryForList("memberTest.getMemberAll");
			
			for(MemberVO mv3 : memList) {
				System.out.println("ID : " + mv3.getMem_id());
				System.out.println("이름 : " + mv3.getMem_name());
				System.out.println("전화 : " + mv3.getMem_tel());
				System.out.println("주소 : " + mv3.getMem_addr());
				System.out.println("============================");
			}
			System.out.println("출력 끝 ~~");
			
			
			// 2-4 select 연습
			// 2)응답 결과가 한개가 확실한 경우 => 여러개면 에러 생김, 현재 실행문에서는 생성되고 삭제되기 때문에 delete를 주석 처리 한다.
			
			System.out.println("selelct 연습 시작(결과가 1개인 경우)...");
			
			// 응답 결과가 1개가 확실할 경우에는 queryForObject 메서드를 사용한다.
			MemberVO mv4 = (MemberVO) smc.queryForObject("memberTest.getMember", "d001");
			System.out.println("ID : " + mv4.getMem_id());
			System.out.println("이름 : " + mv4.getMem_name());
			System.out.println("전화 : " + mv4.getMem_tel());
			System.out.println("주소 : " + mv4.getMem_addr());
			System.out.println("============================");
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
