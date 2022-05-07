package learn.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class LeanBeanFactory {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(TestConfig.class).getBeanDefinition();
		factory.registerBeanDefinition("testConfig", beanDefinition);

		// 添加常用的BeanPostProcessor
		AnnotationConfigUtils.registerAnnotationConfigProcessors(factory);

		for (String beanDefinitionName : factory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		System.out.println("==============================");
		// 调用BeanFactoryPostProcessor，补充一些bean的定义
		Map<String, BeanFactoryPostProcessor> beansOfType = factory.getBeansOfType(BeanFactoryPostProcessor.class);
		for (BeanFactoryPostProcessor bean : beansOfType.values()) {
			System.out.println(bean);
			bean.postProcessBeanFactory(factory);
		}

		System.out.println("==============================");

		for (String beanDefinitionName : factory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		// getBean 动作之后，就不会在调用BeanPostProcessor了
		// System.out.println(factory.getBean("bean2"));


		Map<String, BeanPostProcessor> beansOfType1 = factory.getBeansOfType(BeanPostProcessor.class);
		for (BeanPostProcessor bean : beansOfType1.values()) {
			System.out.println(bean);
			factory.addBeanPostProcessor(bean);
		}

		// 提取初始化所有单例对象
		factory.preInstantiateSingletons();

		// 默认延迟处理
		System.out.println(factory.getBean("bean2"));


	}

}


