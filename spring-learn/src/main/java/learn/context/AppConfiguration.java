package learn.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfiguration {

	@Bean
	public AppService1 appService1() {
		return new AppService1();
	}

	@Bean
	public AppService2 appService2() {
		return new AppService2();
	}

}
