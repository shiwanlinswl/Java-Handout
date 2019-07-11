package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if("/toAdd".equals(action)){
			
			request.getRequestDispatcher(
					"/WEB-INF/addEmp.jsp")
			.forward(request, response);
			
		}else if("/list".equals(action)){
			EmployeeDAO dao = 
					new EmployeeDAO();
			try{
				List<Employee> employees = 
						dao.findAll();
				//step1.绑订数据到request。
				request.setAttribute("employees",
						employees);
				//step2.获得转发器
				RequestDispatcher rd = 
					request.getRequestDispatcher(
							"/WEB-INF/empList.jsp");
				//step3.转发
				rd.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}else if("/add".equals(action)){
			//处理 添加员工的请求
			//读取员工信息
			String ename =
					request.getParameter("ename");
			String salary = 
					request.getParameter("salary");
			String age = 
					request.getParameter("age");
			System.out.println(ename + " "
					+ salary + " " + age);
			
			//将员工信息插入到数据库
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setEname(ename);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			try{
				dao.save(e);
				
				//重定向到员工列表
				response.sendRedirect("list.do");
				
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("<h1>系统繁忙，稍后重试</h1>");
			}
			//容器会自动关闭out,这儿不调用out.close()也可以
			out.close();
		}else if("/del".equals(action)){
			String id = 
					request.getParameter("id");
			EmployeeDAO dao = 
					new EmployeeDAO();
			try{
				dao.delete(Integer.parseInt(id));
				response.sendRedirect("list.do");
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}else if("/load".equals(action)){
			String id = 
					request.getParameter("id");
			EmployeeDAO dao = 
					new EmployeeDAO();
			try{
				Employee e = dao.findById(
						Integer.parseInt(id));
				request.setAttribute("e", e);
				request.getRequestDispatcher(
						"/WEB-INF/updateEmp.jsp")
				.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}else if("/update".equals(action)){
			String id = request.getParameter("id");
			String ename =
					request.getParameter("ename");
			String salary = 
					request.getParameter("salary");
			String age = 
					request.getParameter("age");
			
			Employee e = new Employee();
			e.setId(Integer.parseInt(id));
			e.setEname(ename);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			
			EmployeeDAO dao = new EmployeeDAO();
			try{
				dao.update(e);
				response.sendRedirect("list.do");
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}
	}
}






