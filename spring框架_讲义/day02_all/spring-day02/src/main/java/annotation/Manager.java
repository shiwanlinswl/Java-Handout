package annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	//@Resource(name="wt")
	private Waiter wt;
	
	@Value("苍老师")
	private String name;
	
	@Value("#{config['biz1.pagesize']}")
	private int pageSize;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Resource(name="wt")
	public void setWt(Waiter wt) {
		System.out.println("setWt() " + wt);
		this.wt = wt;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Manager [wt=" + wt + ", name=" + name + ", pageSize=" + pageSize + "]";
	}

	public Manager() {
		System.out.println("Manager()");
	}
	
	
}
