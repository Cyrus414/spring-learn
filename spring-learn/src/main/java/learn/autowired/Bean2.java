package learn.autowired;

import org.springframework.beans.factory.annotation.Autowired;

class Bean2 {
	@Autowired
	private Bean1 bean1;

	@Override
	public String toString() {
		return "Bean2{" +
				"bean1=" + bean1 +
				'}';
	}
}
