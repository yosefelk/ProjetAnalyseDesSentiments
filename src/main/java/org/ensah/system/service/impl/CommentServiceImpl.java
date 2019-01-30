package org.ensah.system.service.impl;

import java.util.List;

import org.ensah.system.beans.Comment;
import org.ensah.system.dao.CommentDao;
import org.ensah.system.service.CommentService;

public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public void saveComment(Comment Comment) {
		
		commentDao.saveComment(Comment);

	}
	
	public List<Comment> getAllComments(int postId) {
		return commentDao.getAllComments(postId);
	}

	

}
