package cn.edu.zju.cst.ideas.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.zju.cst.ideas.dao.IBaseDao;
import cn.edu.zju.cst.ideas.domain.PageBean;
import cn.edu.zju.cst.ideas.util.QueryHelper;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T> {

	@Resource
	protected SessionFactory sessionFactory;
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T> T getById(Integer id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}

	}

	@Override
	public List<T> getDomainsByTypeId(String typeId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName() + "c WHERE c.Id = :typeId ")//
				.setParameter("typeId", typeId)//
				.list();

	}

	@Override
	public <T> List<T> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession()
					.createQuery(//
							"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	@Override
	public List<T> findTopDomainList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName() + " c WHERE c.parent IS NULL")//
				.list();
	}

	@Override
	public <T> T getByName(String name) {
		// TODO Auto-generated method stub
		return (T) sessionFactory.getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName() + " c WHERE c.name = :name")//
				.setParameter(0, name)//
				.list().get(0);
	}

	@Override
	public List<T> findSubDomainList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery(//
						"FROM" + clazz.getSimpleName() + " c WHERE c.parent IS NOT NULL")//
				.list();
	}

	@Override
	public <T> List<T> findAll() {
		// TODO Auto-generated method stub
		return getSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName())//
				.list();
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		// �����б�
		List<Object> parameters = queryHelper.getParameters();

		// ��ѯ��ҳ������б�
		Query listQuery = getSession().createQuery(queryHelper.getListQueryHql()); // ������ѯ����
		if (parameters != null) { // ���ò���
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // ִ�в�ѯ

		// ��ѯ�ܼ�¼����
		Query countQuery = getSession().createQuery(queryHelper.getCountQueryHql());
		if (parameters != null) { // ���ò���
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // ִ�в�ѯ

		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

}
