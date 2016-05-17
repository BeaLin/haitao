package cn.edu.zju.cst.ideas.dao;

import java.util.List;

import cn.edu.zju.cst.ideas.domain.PageBean;
import cn.edu.zju.cst.ideas.util.QueryHelper;

public interface IBaseDao<T> {

	/**
	 * ��id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public <T> T getById(Integer id);
	
	public List<T> getDomainsByTypeId(String typeId);
	
	public List<T> findTopDomainList();

	public List<T> findSubDomainList();
	
	public <T> T getByName(String name);

	/**
	 * ��ѯ���id������
	 * 
	 * @param ids
	 * @return
	 */
	public <T> List<T> getByIds(Long[] ids);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public <T> List<T> findAll();

	/**
	 * �����Ĳ�ѯ��ҳ��Ϣ
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL���������б�
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
