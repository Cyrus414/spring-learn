package learn.autowired;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;


public class LeanAutowired {
	public static void main(String[] args) {
		System.out.println("========================");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		beanFactory.registerSingleton("bean1", new Bean1());
		beanFactory.registerSingleton("bean2", new Bean2());

		beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver()); // @Value

		System.out.println(beanFactory.getBean(Bean2.class));
		
		// 1. 查找哪些属性、方法加了@Autowired注解
		AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
		processor.setBeanFactory(beanFactory);

//		PropertyDescriptor dp = new PropertyDescriptor();
		processor.postProcessProperties(null, beanFactory.getBean(Bean2.class), "bean2"); // 执行依赖注入


		System.out.println(beanFactory.getBean(Bean2.class));

	}
}
