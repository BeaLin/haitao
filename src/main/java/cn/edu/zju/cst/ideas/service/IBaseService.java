package cn.edu.zju.cst.ideas.service;

import java.util.List;

import cn.edu.zju.cst.ideas.domain.PageBean;
import cn.edu.zju.cst.ideas.util.QueryHelper;

public interface IBaseService<T> {
    T getById(Integer id);
	
	List<T> getByIds(Long[] ids);

	List<T> findAll();
	
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
