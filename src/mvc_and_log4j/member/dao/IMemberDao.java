package mvc_and_log4j.member.dao;

import java.util.List;

import mvc_and_log4j.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행후 결과를 작성하여
 * Service에 전달하는 DAO의 interface 
 * @author Jeon
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO 에 담겨진 자료를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 자료가 저장된 MemberVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환됨.
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * 주어진 회원 ID가 존재하는지 여부를 알아내는 메서드
	 * @param memId
	 * @return 해당 회원 ID가 있으면 true, 없으면 false
	 */
	public boolean getMember(String memId);
	
	/**
	 * DB의 mymember 테이블의 전체 레코드를 가져와 List에 담아서
	 * 반환하는 메서드
	 * @return MemberVO 객체를 담고 있는 List 객체
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 하나의 MemberVO 자료를 이용하여 DB를 update하는 메서드
	 * @param mv update할 회원 정보가 들어 있는 MemberVO 객체
	 * @return 작업성공:1, 작업실패:0
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int deleteMember(String memId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}