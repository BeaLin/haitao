package cn.edu.zju.cst.ideas.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.ISiteDao;
import cn.edu.zju.cst.ideas.domain.Site;
import cn.edu.zju.cst.ideas.service.ISiteService;

@Repository
public class SiteService extends BaseService<Site> implements ISiteService{
	
	@Resource
	private ISiteDao siteDao;

	public ISiteDao getSiteDao() {
		return siteDao;
	}

	public void setSiteDao(ISiteDao siteDao) {
		this.siteDao = siteDao;
	}
}
