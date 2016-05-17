package cn.edu.zju.cst.ideas.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import cn.edu.zju.cst.ideas.dao.IEmployeeDao;
import cn.edu.zju.cst.ideas.domain.Employee;

@Component
public class EmployeeDao implements IEmployeeDao {
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")//
				.list();//
	}

}
