package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.Employee;

@Repository("empDAO")
public class EmployeeDAOJdbcImpl implements EmployeeDAO{
	@Resource(name="ds")
	private DataSource ds;
	
	public List<Employee> findAll() {
		List<Employee> employees = 
				new ArrayList<Employee>();
			Connection conn = null;
			try {
				conn = ds.getConnection();
				String sql = "SELECT * FROM t_emp";
				PreparedStatement ps = 
					conn.prepareStatement(sql);
				ResultSet rs = 
						ps.executeQuery();
				
				while(rs.next()){
					Employee e = new Employee();
					e.setId(rs.getInt("id"));
					e.setEname(rs.getString("ename"));
					e.setSalary(rs.getDouble("salary"));
					e.setAge(rs.getInt("age"));
					employees.add(e);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
			return employees;
	}

}
