package learn.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cyrus Chen
 * @Date: 5/7/22 9:09 AM
 * @Description:
 */
@Configuration
class TestConfig {
	@Bean
	public Bean1 bean1() {
		return new Bean1();
	}

	@Bean
	public Bean2 bean2() {
		return new Bean2();
	}

}
