package cn.edu.zju.cst.ideas.dao.impl;

import org.springframework.stereotype.Repository;


import cn.edu.zju.cst.ideas.dao.ICommentDao;
import cn.edu.zju.cst.ideas.domain.Comment;



@Repository(ICommentDao.SERVICE_NAME)
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements ICommentDao{

}
