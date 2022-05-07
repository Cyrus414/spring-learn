package learn.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@ComponentScan
class LifeCycleBean {
	public LifeCycleBean() {
		System.out.println("构造 lifeCycleBean");
	}

	@Autowired
	public void autowaired(@Value("${JAVA_HOME}") String path) {
		System.out.println("依赖注入： " + path);
	}

	@PostConstruct
	public void construct() {
		System.out.println("初始化后置处理器");
	}

	@PreDestroy
	public void desctrcut() {
		System.out.println("销毁前处理");
	}
}
