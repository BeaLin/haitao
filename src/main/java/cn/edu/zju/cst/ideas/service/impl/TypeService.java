package cn.edu.zju.cst.ideas.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.ITypeDao;
import cn.edu.zju.cst.ideas.domain.PageBean;
import cn.edu.zju.cst.ideas.domain.Type;
import cn.edu.zju.cst.ideas.service.ITypeService;
import cn.edu.zju.cst.ideas.util.QueryHelper;

@Repository
public class TypeService  implements ITypeService{
	
	@Resource
	private ITypeDao typeDao;

	public ITypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(ITypeDao typeDao) {
		this.typeDao = typeDao;
	}

	@Override
	public Type getById(Integer id) {
		return typeDao.getById(id);
	}

	@Override
	public List<Type> getByIds(Long[] ids) {
		return typeDao.getByIds(ids);
	}

	@Override
	public List<Type> findAll() {
		return typeDao.findAll();
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return typeDao.getPageBean(pageNum, pageSize, queryHelper);
	}
}
