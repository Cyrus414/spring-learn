package learn.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
class LifeCycleBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if ("lifeCycleBean".equals(beanName)) System.out.println("bean 实例化前: " + beanName);
		// 返回值不为null时会替换掉容器中的bean
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if ("lifeCycleBean".equals(beanName)) System.out.println("bean 实例化后: " + beanName);
		// 返回false时不会执行后续的bean初始化，会跳过依赖注入阶段
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		if ("lifeCycleBean".equals(beanName)) System.out.println("bean 依赖注入前: " + beanName);
		return pvs;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("lifeCycleBean".equals(beanName)) System.out.println("bean 初始化前: " + beanName);
		// 返回值不为null时会替换掉容器中的bean
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("lifeCycleBean".equals(beanName)) System.out.println("bean 初始化后: " + beanName);
		// 返回false时不会执行后续的bean初始化，会跳过依赖注入阶段
		return bean;
	}

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if ("lifeCycleBean".equals(beanName)) System.out.println("bean 销毁前: " + beanName);
	}


}
