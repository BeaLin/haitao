package cn.edu.zju.cst.ideas.service.impl;

import java.util.List;

import cn.edu.zju.cst.ideas.dao.IBaseDao;
import cn.edu.zju.cst.ideas.domain.PageBean;
import cn.edu.zju.cst.ideas.service.IBaseService;
import cn.edu.zju.cst.ideas.util.QueryHelper;


public class BaseService<T> implements IBaseService<T> {
  
	
	private IBaseDao<T> basedao;
	
	public IBaseDao getBasedao() {
		return basedao;
	}

	public void setBasedao(IBaseDao basedao) {
		this.basedao = basedao;
	}

	@Override
	public T getById(Integer id) {
		return basedao.getById(id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		return basedao.getByIds(ids);
	}

	@Override
	public List<T> findAll() {
		return basedao.findAll();
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return basedao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
