package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ld")
public class Leader {
	private Waiter wt;

	@Autowired
	public Leader(
			@Qualifier("wt") Waiter wt) {
		System.out.println("Leader() " + wt);
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Leader [wt=" + wt + "]";
	}
	
}
