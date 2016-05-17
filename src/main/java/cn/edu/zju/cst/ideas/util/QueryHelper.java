package cn.edu.zju.cst.ideas.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.cst.ideas.dao.IBaseDao;
import cn.edu.zju.cst.ideas.domain.PageBean;

/**
 * ���ڸ���HQL��ƴ��
 *
 */
public class QueryHelper {
	
	private String fromClause; // FROM�Ӿ�
	private String whereClause = ""; // Where�Ӿ�
	private String orderByClause = ""; // OrderBy�Ӿ�
	
	private List<Object> parameters = new ArrayList<Object>(); // �����б�
	
	/**
	 * ���From�Ӿ�
	 * 
	 * @param clazz
	 * @param alias
	 * 
	 */
	public QueryHelper(Class clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}
	
	/**
	 * ƴ��Where�Ӿ�
	 * 
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(String condition, Object... params) {
		// ƴ��
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause += " AND " + condition;
		}

		// ����
		if (params != null) {
			for (Object p : params) {
				parameters.add(p);
			}
		}

		return this;
	}
	
	/**
	 * ����һ������Ϊtrue����ƴ��Where�Ӿ�
	 * 
	 * @param append
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(boolean append, String condition, Object... params) {
		if (append) {
			addCondition(condition, params);
		}
		return this;
	}
	
	/**
	 * ƴ��OrderBy�Ӿ�
	 * 
	 * @param propertyName
	 *            ���������������
	 * @param asc
	 *            true��ʾ����false��ʾ����
	 */
	public QueryHelper addOrderProperty(String propertyName, boolean asc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (asc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (asc ? " ASC" : " DESC");
		}
		return this;
	}

	/**
	 * ����һ������Ϊtrue����ƴ��OrderBy�Ӿ�
	 * 
	 * @param append
	 * @param propertyName
	 * @param asc
	 */
	public QueryHelper addOrderProperty(boolean append, String propertyName, boolean asc) {
		if (append) {
			addOrderProperty(propertyName, asc);
		}
		return this;
	}
	
	/**
	 * ��ȡ��ɵ����ڲ�ѯ����б��HQL���
	 * 
	 * @return
	 */
	public String getListQueryHql() {
		return fromClause + whereClause + orderByClause;
	}

	/**
	 * ��ȡ��ɵ����ڲ�ѯ�ܼ�¼���HQL���
	 * 
	 * @return
	 */
	public String getCountQueryHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}

	/**
	 * ��ȡHQL�еĲ���ֵ�б�
	 * 
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	/**
	 * ��ѯ��ҳ��Ϣ�����ŵ�ֵջջ��
	 * 
	 * @param service
	 * @param pageNum
	 * @param pageSize
	 */
	public void preparePageBean(IBaseDao<?> service, int pageNum, int pageSize) {
		PageBean pageBean = service.getPageBean(pageNum, pageSize, this);
		ActionContext.getContext().getValueStack().push(pageBean);
	}

	
}
