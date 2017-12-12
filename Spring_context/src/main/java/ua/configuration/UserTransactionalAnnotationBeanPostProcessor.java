package ua.configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import ua.annotation.UserTransactional;

@Component
public class UserTransactionalAnnotationBeanPostProcessor implements BeanPostProcessor{
	
	public Object postProcessAfterInitialization(final Object bean, String beanId) throws BeansException {
		if(!beanHaveTransactionalAnnotation(bean)) return bean;
		Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
			public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
				if(!ReflectionUtils.findMethod(bean.getClass(), method.getName()).isAnnotationPresent(UserTransactional.class)) return method.invoke(bean, args);
				System.out.println("Transaction start");
				Object res = method.invoke(bean, args);
				System.out.println("Transaction end");
				return res;
			}
		});
		return proxy;
	}

	private boolean beanHaveTransactionalAnnotation(Object bean) {
		Method[] declaredMethods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
		for (Method method : declaredMethods) {
			if(method.isAnnotationPresent(UserTransactional.class)) {
				return true;
			}
		}
		return false;
	}
	
	//�������� ���, ������� �������� ��� �������, ���� ����� ����� ����������� � ���� � ����������� �� ��� ����������, ������� ��������� ��� � ����
	//�������� ���� ���, �� ������� ��� ������� ��� ������� ����� ��� ���������
	public Object postProcessBeforeInitialization(Object bean, String beanId) throws BeansException {
		
		return bean;
	}
}
