package cn.edu.zju.cst.ideas.dao;

import cn.edu.zju.cst.ideas.domain.Type;

public interface ITypeDao extends IBaseDao<Type> {
	public final static String SERVICE_NAME="cn.edu.zju.cst.ideas.dao.ITypeDao";
	
	 public String getTypeName(int typeId);
}
