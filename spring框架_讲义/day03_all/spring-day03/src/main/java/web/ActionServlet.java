package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BmiService;

/**
 * 控制器:
 * 	负责做两件事:
 * 	1.分析请求路径，调用对应的模型来处理。
 *  2.依据模型返回的结果，调用对应的视图来展现。
 *
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		/*
		 * 分析请求路径，调用对应的模型来处理。
		 */
		String uri = 
				request.getRequestURI();
		String action = 
				uri.substring(uri.lastIndexOf("/"),
						uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if("/toBmi".equals(action)){
			
			request.getRequestDispatcher(
					"/WEB-INF/bmi_form.jsp")
			.forward(request, response);
			
		}else if("/bmi".equals(action)){
			String height = 
					request.getParameter("height");
			String weight = 
					request.getParameter("weight");
			System.out.println("height:" + height
					+ " weight:" + weight);
			BmiService service = 
					new BmiService();
			String status = 
					service.bmi(
						Double.parseDouble(height), 
						Double.parseDouble(weight));
			/*
			 * 依据模型返回的结果，调用对应的视图来展现。
			 */
			request.setAttribute("status", status);
			request.getRequestDispatcher(
					"/WEB-INF/view2.jsp")
			.forward(request, response);
			
		}
		
		
		
		
		
	}

}





