package cn.edu.zju.cst.ideas.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.ISiteDao;
import cn.edu.zju.cst.ideas.domain.Site;



@Repository(ISiteDao.SERVICE_NAME)
public class SiteDaoImpl extends BaseDaoImpl<Site> implements ISiteDao{

}
