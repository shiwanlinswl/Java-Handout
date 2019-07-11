package autowire;

public class Restaurant2 {
	private Waiter2 wt;

	public void setWt(Waiter2 wt) {
		System.out.println("setWt() " + wt);
		this.wt = wt;
	}

	public Restaurant2() {
		System.out.println("Restaurant2()");
	}

	@Override
	public String toString() {
		return "Restaurant2 [wt=" + wt + "]";
	}
	
	
	
}
