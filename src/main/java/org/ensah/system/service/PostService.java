package org.ensah.system.service;

import java.util.List;

import org.ensah.system.beans.Post;
public interface PostService {
	
	public void savePost(Post post);

	public List<Post> getAllPosts(int userId);

	public Post getPost(int postId);
	
	public void setPostPolarity(int p_id, int polarity);

}
