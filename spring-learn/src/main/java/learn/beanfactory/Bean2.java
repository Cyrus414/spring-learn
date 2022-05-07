package learn.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Cyrus Chen
 * @Date: 5/7/22 9:09 AM
 * @Description:
 */
class Bean2 {

	@Autowired
	private Bean1 bean1;

	public Bean2() {
		System.out.println("Bean2 constructor");
	}

	@Override
	public String toString() {
		return "Bean2{" +
				"bean1=" + bean1 +
				'}';
	}
}
