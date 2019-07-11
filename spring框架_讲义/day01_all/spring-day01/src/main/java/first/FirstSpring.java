package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		String config = "applicationContext.xml";
		//启动Spring容器
		/*
		 * ApplicationContext:容器接口
		 * ClassPathXmlApplicationContext:是实现了
		 * 上述接口的类。
		 * 注：依据类路径查找配置文件，然后启动Spring
		 * 容器。
		 */
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		//通过容器获得对象
		Apple a1 = ac.getBean("a1",Apple.class);
		System.out.println("a1:" + a1);
		
		Date date1 = ac.getBean("date1",Date.class);
		System.out.println("date1:" + date1);
		
		Calendar cal1 = ac.getBean("cal1",Calendar.class);
		System.out.println("cal1:" + cal1);
		
		Date time1 = 
				ac.getBean("time1",Date.class);
		System.out.println("time1:" + time1);
		
		
		
	}
	
	
	

}
