package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Restaurant2;
import basic.ExampleBean;
import basic.MessageBean;
import ioc.A;
import ioc.Restaurant;

public class TestCase {
	@Test
	//测试 作用域
	public void test1(){
		String config = "basic.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		ExampleBean eb1 = 
				ac.getBean("eb1",ExampleBean.class);
		ExampleBean eb2 = 
				ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1 == eb2);
	}
	
	@Test
	//测试 生命周期相关的两个方法。
	public void test2(){
		String config = "basic.xml";
		/*
		 * ApplicationContext接口没有提供关闭
		 * 容器的方法（close方法），需要使用其子接口
		 * AbstractApplicationContext。
		 */
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		MessageBean mb1 = 
				ac.getBean("mb1",MessageBean.class);
		mb1.sendMsg();
		ac.close();
	}
	
	@Test
	//测试 延迟加载
	public void test3(){
		String config = "basic.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
	}
	
	@Test
	//测试 set方法注入
	public void test4(){
		String config = "ioc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		A a1 = ac.getBean("a1",A.class);
		a1.execute();
	}
	
	@Test
	//测试 构造器注入
	public void test5(){
		String config = "ioc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Restaurant rest1 = 
				ac.getBean("rest1",Restaurant.class);
		System.out.println(rest1);
	}
	
	@Test
	//测试 自动装配
	public void test6(){
		String config = "autowire.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Restaurant2 rest = 
				ac.getBean("rest",Restaurant2.class);
		System.out.println(rest);
		
	}
}








