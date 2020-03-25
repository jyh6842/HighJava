package mvc.test;

import java.util.List;

public class MemberServiceImp implements IMemberService{

	// 사용할 DAO의 객체 변수를 선언한다.
	private IMemberDao memDao;
	
	public MemberServiceImp() {
		memDao = new MeberDaoImpl();
	}
	@Override
	public int insertMember(MemberVO mv) {
		return memDao.insertMember(mv);
	}

	@Override
	public boolean getMember(String memId) {
		// TODO Auto-generated method stub
		return memDao.getMember(memId);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		// TODO Auto-generated method stub
		return memDao.getAllMemberList();
	}

	@Override
	public int updateMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return memDao.updateMember(mv);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return memDao.deleteMember(memId);
	}

}
