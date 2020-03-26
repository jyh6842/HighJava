package singleton.mvc.member.service;

import java.util.List;

import singleton.mvc.member.dao.IMemberDao;
import singleton.mvc.member.dao.MemberDaoImpl;
import singleton.mvc.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	// 사용할 DAO의 객체 변수를 선언한다.
	private IMemberDao memDao;

	private static MemberServiceImpl memService;

	public MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}

	public static MemberServiceImpl getInstance() {
		if (memService == null) {
			memService = new MemberServiceImpl();
		}

		return memService;

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
