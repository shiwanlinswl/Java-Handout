package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public ModelAndView handleRequest(
			HttpServletRequest arg0,
			HttpServletResponse arg1) 
					throws Exception {
		System.out.println("handleRequest()");
		/*
		 * ModelAndView有两个常用的构造器
		 * ModelAndView(String viewName)
		 * ModelAndView(String viewName,Map data)
		 * 注:
		 * 		viewName:视图名
		 * 		data: 数据
		 */
		return new ModelAndView("hello");
	}
	

}
