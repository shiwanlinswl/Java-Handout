package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import json.Stock;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		
		System.out.println("action:" + action);
		if ("/quoto".equals(action)) {
			// 模拟生成几只股票信息
			List<Stock> stocks = new ArrayList<Stock>();
			Random r = new Random();
			for (int i = 0; i < 8; i++) {
				Stock s = new Stock();
				s.setCode("60087" + r.nextInt(10));
				s.setName("中国嘉陵" + r.nextInt(10));
				s.setPrice(r.nextInt(1000));
				stocks.add(s);
			}
			// 使用jackson提供的api来转换
			ObjectMapper om = new ObjectMapper();
			String jsonStr = om.writeValueAsString(stocks);
			System.out.println(jsonStr);
			
			//将json字符串发送给浏览器
			out.println(jsonStr);
		}else if("/getNumber".equals(action)){
			Random r = new Random();
			int number = r.nextInt(100);
			System.out.println("number:" + number);
			out.println(number);
		}else if("/check".equals(action)){
			String uname = 
					request.getParameter("uname");
			System.out.println("uname:" + uname);
			if("Sally".equals(uname)){
				out.println("用户名被占用");
			}else{
				out.println("可以使用");
			}
		}

	}

}
