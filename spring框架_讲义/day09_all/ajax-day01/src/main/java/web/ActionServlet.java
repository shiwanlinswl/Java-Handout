package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = 
				request.getRequestURI();
		String action = 
				uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if("/check".equals(action)){
			String uname = 
					request.getParameter("uname");
			System.out.println("uname:" + uname);
			if("Sally".equals(uname)){
				out.println("用户名被占用");
			}else{
				out.println("可以使用");
			}
		}else if("/getNumber".equals(action)){
			Random r = new Random();
			int number = r.nextInt(1000);
			System.out.println("number:" + number);
			out.println(number);
		}
	}
	
}





