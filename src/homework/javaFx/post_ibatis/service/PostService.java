package homework.javaFx.post_ibatis.service;

import java.util.List;

import homework.javaFx.post_ibatis.dao.IPostDao;
import homework.javaFx.post_ibatis.dao.PostDao;
import homework.javaFx.post_ibatis.vo.PostVO;

public class PostService implements IPostService{
	
	private IPostDao postDao;
	
	private static IPostService postService;
	
	private PostService() {
		postDao = PostDao.getInstance();
	}
	
	public static IPostService getInstance() {
		if(postService == null ) {
			postService = new PostService();
		}
		return postService;
	}

	@Override
	public List<PostVO> getselectPostDong(String dongString) {
		return postDao.getselectPostDong(dongString);
	}

	@Override
	public List<PostVO> getselectPostNum(String numString) {
		return postDao.getselectPostNum(numString);
	}

}
