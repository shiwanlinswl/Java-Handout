package cn.tedu.ems.dao;

import java.util.List;

import cn.tedu.ems.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
}
