package cn.tedu.ems.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.EmployeeDAO;
import cn.tedu.ems.entity.Employee;

@Service("empService")
public class EmpServiceImpl implements EmpService{
	@Resource(name="empDAO")
	private EmployeeDAO employeeDAO;
	public List<Employee> list() {
		return employeeDAO.findAll();
	}

}
