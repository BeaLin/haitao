package cn.edu.zju.cst.ideas.service;

import java.util.List;

import cn.edu.zju.cst.ideas.domain.PageBean;
import cn.edu.zju.cst.ideas.domain.Type;
import cn.edu.zju.cst.ideas.util.QueryHelper;

public interface ITypeService {

	Type getById(Integer id);

	List<Type> getByIds(Long[] ids);

	List<Type> findAll();

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
