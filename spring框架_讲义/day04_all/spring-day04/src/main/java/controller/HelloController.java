package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//@RequestMapping("/demo")
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		//返回视图名
		return "hello";
	}
	
	@RequestMapping("/toBmi.do")
	public String toBmi(){
		System.out.println("toBmi()");
		return "bmi";
	}
	
	@RequestMapping("/bmi.do")
	/*(了解)
	 * DispatcherServlet利用java反射分析处理器的
	 * 方法签名（方法名，参数类型，返回类型），然后
	 * 将需要的对象作为参数传进来。
	 * 比如，这儿，需要有一个request对象，
	 * DispatcherServlet就会将request作为参数传进来。
	 */
	public String bmi(
			HttpServletRequest request){
		System.out.println("bmi()");
		String height = 
				request.getParameter("height");
		String weight = 
				request.getParameter("weight");
		System.out.println(height + " " + weight);
		return "view";
	}
	
	@RequestMapping("/bmi2.do")
	/*
	 * (了解)
	 * DispatcherServlet利用java反射分析方法的签名，
	 * 会将参数值获得之后，赋给对应的形参。
	 * 注：
	 * 	可以使用@RequestParam注解告诉DispatcherServlet,
	 *  形参名与请求参数名的对应关系。
	 */
	public String bmi2(
			@RequestParam("height") String height1,
			String weight){
		System.out.println("bmi2()");
		System.out.println(height1 + " " + weight);
		return "view";
	}
	
	@RequestMapping("/bmi3.do")
	/*
	 * (了解)
	 * DispatcherServlet通过反射分析方法的签名，
	 * 会将BmiPraram对象创建好之后传进来。
	 * 注：
	 * 	 会读取相应的请求参数值，并且，会做类型转换。
	 */
	public String bmi3(BmiParam bp){
		System.out.println("bmi3()");
		System.out.println(bp.getHeight() 
				+ " " + bp.getWeight());
		return "view";
	}
	
	@RequestMapping("/bmi4.do")
	public String bmi4(BmiParam bp,
			HttpServletRequest request){
		System.out.println("bmi4()");
		double height = bp.getHeight();
		double weight = bp.getWeight();
		double bmi = 
				weight / height / height;
		String status = "正常";
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		request.setAttribute("status", status);
		//默认就是转发
		return "view";
	}
	
	@RequestMapping("/bmi5.do")
	public ModelAndView bmi5(BmiParam bp){
		System.out.println("bmi5()");
		
		double height = bp.getHeight();
		double weight = bp.getWeight();
		double bmi = 
				weight / height / height;
		String status = "正常";
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		
		/*
		 * 将数据添加到ModelAndView。
		 * 注（了解）
		 * 	DispatcherServlet会将数据(data)取出来，
		 * 然后绑订到request上（以key作为绑订名）。
		 */
		Map<String,Object> data = 
				new HashMap<String,Object>();
		data.put("status", status);
		ModelAndView mav = 
				new ModelAndView("view",data);
		return mav;
	}
	
	@RequestMapping("/bmi6.do")
	public String bmi6(BmiParam bp,
			ModelMap mm){
		System.out.println("bmi6()");
		
		double height = bp.getHeight();
		double weight = bp.getWeight();
		double bmi = 
				weight / height / height;
		String status = "正常";
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		/*
		 * DispatcherServlet从ModelMap中取出数据，
		 * 然后绑订到request上（以key作为绑订名）。
		 */
		mm.addAttribute("status", status);
		
		return "view";
	}
	
	@RequestMapping("/bmi7.do")
	public String bmi7(BmiParam bp,
			HttpSession session){
		System.out.println("bmi7.do");
		
		double height = bp.getHeight();
		double weight = bp.getWeight();
		double bmi = 
				weight / height / height;
		String status = "正常";
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		session.setAttribute("status", status);
		return "view";
	}
	
	@RequestMapping("/bmi8.do")
	public String bmi8(){
		System.out.println("bmi8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	
	@RequestMapping("/bmi9.do")
	public ModelAndView bmi9(){
		System.out.println("bmi9()");
		RedirectView rv = 
				new RedirectView("toIndex.do");
		ModelAndView mav = 
				new ModelAndView(rv);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





