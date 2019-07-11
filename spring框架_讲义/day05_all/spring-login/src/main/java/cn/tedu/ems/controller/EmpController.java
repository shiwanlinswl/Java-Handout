package cn.tedu.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.Employee;
import cn.tedu.ems.service.EmpService;

@Controller
public class EmpController {
	@Resource(name="empService")
	private EmpService empService;
	
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request){
		List<Employee> employees = 
				new ArrayList<Employee>();
		try{
			employees = empService.list();
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		request.setAttribute("employees", employees);
		return "empList";
	}
}
