package cn.tedu.ems.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.AppException;
import cn.tedu.ems.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@ExceptionHandler
	public String handleException(Exception e,
			HttpServletRequest request){
		System.out.println("handleException()");
		if(e instanceof AppException){
			//应用异常，明确提示用户采取正确的操作
			request.setAttribute(
					"login_failed", e.getMessage());
			return "login";
		}
		//系统异常
		return "error";
	}
	
	/*
	 * 生成一个长度固定为size个字符，并且这些字符要求从
		(A~Z,0~9)中随机选取，比如 X09BD
	 */
	private String getNumber(int size) {
		Random r = new Random();
		String number = "";
		String chars = "ABCDEFGHIJKLMNOPQRS"
				+ "TUVWXYZ0123456789";
		for(int i = 0; i < size; i ++){
			number += chars.charAt(
					r.nextInt(chars.length()));
		}
		return number;
	}
	
	@RequestMapping("/checkcode.do")
	/*
	 * 输出验证码图片
	 */
	public void checkcode(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		/*
		 * step1. 绘图
		 * 
		 */
		//先创建一个画布(内存映像对象)
		BufferedImage image = 
				new BufferedImage(80,30,
						BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g = image.getGraphics();
		//给画笔设置颜色
		g.setColor(new Color(255,255,255));
		//给画布设置背景颜色(即给画布上色)
		g.fillRect(0, 0, 80, 30);
		//给画笔设置颜色
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//设置字体 (字体，风格，大小)
		g.setFont(new Font(null,
				Font.BOLD|Font.ITALIC,24));
		
		//生成验证码
		String number = getNumber(5);
		System.out.println("number:" + number);
		
		//将验证码(number)绑订到session对象上
		HttpSession session = 
				request.getSession();
		session.setAttribute("number", number);
		
		
		//在画布上绘图(将验证码转换成一张图片)
		g.drawString(number, 1, 25);
		
		//加一些干扰线
		for(int i = 0; i < 8; i ++){
			g.setColor(new Color(r.nextInt(255),
					r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));	
		}
		
		/*
		 * step2.将图片压缩，然后输出
		 */
		//设置content-type  
		response.setContentType("image/jpeg");
		//获得字节输出流（图片是二进制数据）
		OutputStream os = 
				response.getOutputStream();
		//将原始图片(image)按照指定的算法压缩(jpeg),
		//然后将压缩之后得到的字节写入response对象。
		javax.imageio.ImageIO.write(
				image, "jpeg", os);
		os.close();
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,
			HttpSession session){
		System.out.println("login()");
		/**
		 * 先比较验证码：用户提交的验证码和session
		 * 对象上事先绑订的验证码进行比较。如果不相等，
		 * 则提示用户验证码错误，否则再比较用户名和密码。
		 */
		String number1 = 
				request.getParameter("number");
		String number2 = 
				(String)session.getAttribute("number");
		if(!number1.equals(number2)){
			request.setAttribute(
					"number_error", "验证码错误");
			return "login";
		}
		String username = 
				request.getParameter("uname");
		String pwd = 
				request.getParameter("pwd");
		System.out.println("username:" 
				+ username + " pwd:" + pwd);
		
		//将登录请求分发给业务层的对象来处理
			User user = 
					loginService.checkLogin(
							username, pwd);
		//登录成功，绑订数据到session
		session.setAttribute("user", user);
		//登录成功，重定向到首页
		return "redirect:toIndex.do";
	}
	
	
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}









