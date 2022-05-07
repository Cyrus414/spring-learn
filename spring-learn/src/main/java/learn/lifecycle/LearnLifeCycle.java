package learn.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LearnLifeCycle {
	public static void main(String[] args) {
		System.out.println("===========================");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleBean.class);
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println("bean definition name: " + beanDefinitionName);
		}
		context.getBean(LifeCycleBean.class);
		context.close();
	}
}
