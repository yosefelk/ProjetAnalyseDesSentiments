package org.ensah.system.service;

import java.util.List;

import org.ensah.system.beans.Comment;
public interface CommentService {
	
	public void saveComment(Comment comment);

	public List<Comment> getAllComments(int postId);

}
