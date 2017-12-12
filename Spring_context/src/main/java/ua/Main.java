package ua;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.service.SomeService;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/context.xml");
		SomeService service = context.getBean(SomeService.class);
		service.one();
		service.two();
		context.close();
	}

}
