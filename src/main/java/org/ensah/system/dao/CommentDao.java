package org.ensah.system.dao;

import java.util.List;

import org.ensah.system.beans.Comment;

public interface CommentDao {
	
	public void saveComment(Comment comment);

	public List<Comment> getAllComments(int postId);

}
