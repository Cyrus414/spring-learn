package learn.context;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class LearnApplicationContext {
	public static void main(String[] args) {
		System.out.println("=============");
//		xmlApplicationContext();
//		leanClassPathApplicationContext();
//		leanFileSystemApplicationContext();
		learnAnnotationApplicationContext();
	}

	public static void xmlApplicationContext() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		// 从classpath中加载配置文件
		// reader.loadBeanDefinitions(new ClassPathResource("application.xml"));
		// 从文件系统中加载配置文件
		reader.loadBeanDefinitions(new FileSystemResource("/Users/cyrus/Documents/Workspace/Java/spring-framework/spring-context/src/test/resources/application.xml"));
		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			System.out.println("beanDefinitionName: " + beanDefinitionName);
		}

	}

	public static void leanClassPathApplicationContext () {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println("beanDefinitionName: " + beanDefinitionName);
		}
	}

	public static void leanFileSystemApplicationContext () {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("/Users/cyrus/Documents/Workspace/Java/spring-framework/spring-context/src/test/resources/application.xml");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println("beanDefinitionName: " + beanDefinitionName);
		}
	}

	public static void learnAnnotationApplicationContext () {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println("beanDefinitionName: " + beanDefinitionName);
		}
	}
}


