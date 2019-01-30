package org.ensah.system.dao;

import java.util.List;

import org.ensah.system.beans.Post;

public interface PostDao {
	
	public void savePost(Post post);

	public List<Post> getAllPosts(int postId);

	public Post getPost(int userId);

	public void setPostPolarity(int p_id, int polarity);
}
