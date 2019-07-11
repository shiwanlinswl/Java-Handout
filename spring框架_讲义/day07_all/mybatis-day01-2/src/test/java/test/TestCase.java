package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDAO;
import entity.Emp2;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	private EmployeeDAO dao;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfd = 
				new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = 
				ssfd.build(
				TestCase.class.getClassLoader()
				.getResourceAsStream(
						"SqlMapConfig.xml"));
		session = ssf.openSession();
		//返回符合Mapper映射器要求的对象
		dao = session.getMapper(EmployeeDAO.class);
	}
	
	@Test
	public void test1(){
		
		System.out.println("dao:" 
				+ dao.getClass().getName());
		Employee e = new Employee();
		e.setEname("建国");
		e.setSalary(20000);
		e.setAge(22);
		dao.save(e);
		//仍然需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Employee> employees = 
				dao.findAll();
		System.out.println(employees);
		session.close();
	}
	
	@Test
	public void test3(){
		Map map = dao.findById2(1);
		System.out.println(map);
		session.close();
	}
	
	@Test
	public void test4(){
		Emp2 emp = 
				dao.findById3(1);
		System.out.println(emp);
		session.close();
	}
}














