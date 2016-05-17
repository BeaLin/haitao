package cn.edu.zju.cst.ideas.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.ICommentDao;
import cn.edu.zju.cst.ideas.domain.Comment;
import cn.edu.zju.cst.ideas.service.ICommentService;

@Repository
public class CommentService extends BaseService<Comment> implements ICommentService{

	@Resource
	private ICommentDao  commentDao;

	public ICommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}
}
