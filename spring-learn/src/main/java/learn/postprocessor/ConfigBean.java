package learn.postprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("learn.postprocessor")
class ConfigBean {
//	@Autowired
//	private Bean1 bean1;

	@Bean
	public Bean1 bean1() {
		return new Bean1();
	}
}
