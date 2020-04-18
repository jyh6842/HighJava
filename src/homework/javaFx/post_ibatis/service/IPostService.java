package homework.javaFx.post_ibatis.service;

import java.util.List;

import homework.javaFx.post_ibatis.vo.PostVO;

public interface IPostService {

		/**
		 * 동 검색을 위한 메서드
		 * 컬럼박스가 동이름일 때 사용
		 * @param dongString 를 받아 동 이름에 따른 정보 출력
		 * @return List<PostVO> 값이 여러개 일 수 있어서 사용
		 */
		public List<PostVO> getselectPostDong(String dongString);
		
		/**
		 * 우편번호 검색을 위한 메서드
		 * 우편번호를  검색을 위한 메서드
		 * @param numString 우편번호를 입력하면 해당 동의 정보가 나오도록한다.
		 * @return List<PostVO> 값이 여러개 일 수 있어서 사용
		 */
		public List<PostVO> getselectPostNum(String numString);
}
