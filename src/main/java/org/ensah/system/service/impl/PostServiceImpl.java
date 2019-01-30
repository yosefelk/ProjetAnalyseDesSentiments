package org.ensah.system.service.impl;

import java.util.List;

import org.ensah.system.beans.Post;
import org.ensah.system.dao.PostDao;
import org.ensah.system.service.PostService;

public class PostServiceImpl implements PostService {
	
	private PostDao postDao;
	
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	public void savePost(Post Post) {
		
		postDao.savePost(Post);

	}

	public List<Post> getAllPosts(int userId) { 
		
		return postDao.getAllPosts(userId);
	}

	public Post getPost(int postId) {
		return postDao.getPost(postId);
	}

	public void setPostPolarity(int p_id, int polarity) {
		postDao.setPostPolarity(p_id, polarity);
	}

}
