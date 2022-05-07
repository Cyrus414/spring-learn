package learn.postprocessor;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Method;

public class LearnPostProcessor {
	public static void main(String[] args) {
		System.out.println("====================");
		GenericApplicationContext context = new GenericApplicationContext();

		// 注册bean
		context.registerBean("bean1", Bean1.class);
		context.registerBean("bean2", Bean2.class);
		context.registerBean("bean3", Bean3.class);

		// 添加后处理器
		context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver()); // 帮助解析@Value中的字符串
		context.registerBean(AutowiredAnnotationBeanPostProcessor.class); // @Autowired @Value
		context.registerBean(CommonAnnotationBeanPostProcessor.class); // @Resource @PostConstruct @PreDestroy


		// 初始化容器
		// 执行beanFactory后处理器，添加bean后处理器，初始化单例bean
		context.refresh();

		// 销毁容器
		context.close();
	}
}
