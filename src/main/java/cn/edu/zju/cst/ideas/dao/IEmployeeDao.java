package cn.edu.zju.cst.ideas.dao;

import java.util.List;

import cn.edu.zju.cst.ideas.domain.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAll();
}