package ioc;

public class A {
	private IB b;
	
	/**
	 * 容器会调用该方法，将b作为参数传进来。
	 */
	public void setB(IB b) {
		System.out.println("setB() " + b);
		this.b = b;
	}

	public A() {
		System.out.println("A()");
	}
	
	public void execute(){
		//调用B的f1方法
		b.f1();
	}
	
}
