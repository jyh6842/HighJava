package iBatis.MemberIbatis.test;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;


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
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
