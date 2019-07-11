package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Leader;
import annotation.Manager;
import annotation.Restaurant;
import annotation.Student;

public class TestCase2 {
	@Test
	//测试 组件扫描
	public void test1(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1);
	}
	
	@Test
	//测试 作用域
	public void test2(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		Student stu2 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1 == stu2);
	}
	
	@Test
	//测试 生命周期相关的方法
	public void test3(){
		String config = "annotation.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1);
		ac.close();
		
	}
	
	@Test
	//测试 @Autowired @Qualifier
	public void test4(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Restaurant rest = 
				ac.getBean("rest",Restaurant.class);
		System.out.println(rest);
		
		Leader ld = 
				ac.getBean("ld",Leader.class);
		System.out.println(ld);
	}
	
	@Test
	//测试 @Resource
	public void test5(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		
		Manager mg = 
				ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
}







