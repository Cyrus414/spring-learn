package learn.postprocessor;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

public class LearnPostProcessor2 {
	public static void main(String[] args) {
		System.out.println("====================");
		GenericApplicationContext context = new GenericApplicationContext();

		context.registerBean("configBean", ConfigBean.class);

		// 添加后处理器
		context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver()); // 帮助解析@Value中的字符串
		context.registerBean(AutowiredAnnotationBeanPostProcessor.class); // @Autowired @Value
		context.registerBean(CommonAnnotationBeanPostProcessor.class); // @Resource @PostConstruct @PreDestroy
		context.registerBean(ConfigurationClassPostProcessor.class); // @ComponentScan @Bean @Import @ImportResource


		// 初始化容器
		// 执行beanFactory后处理器，添加bean后处理器，初始化单例bean
		context.refresh();

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println("beanDefinitionName: " + beanDefinitionName);
		}

		// 销毁容器
		context.close();
	}
}
