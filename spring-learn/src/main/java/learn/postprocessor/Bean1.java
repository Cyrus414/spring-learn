package learn.postprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


class Bean1 {
	@Autowired
	public void setBean2(Bean2 bean2) {
		System.out.println("set bean2: " + bean2);
	}

	@Resource
	public void setBean3(Bean3 bean3) {
		System.out.println("set bean3: " + bean3);
	}

	@Autowired
	public void setValue(@Value("${JAVA_HOME}") String path) {
		System.out.println("set value: " + path);
	}

	@PostConstruct
	public void init() {
		System.out.println("初始化 bean1");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("销毁 bean1");
	}
}
