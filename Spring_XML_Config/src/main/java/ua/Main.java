package ua;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.bard.Bard;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/context.xml");
		Bard bard = (Bard) context.getBean("bard1");
		bard.singing();
		Bard bard2 = (Bard) context.getBean("bard2");
		bard2.singing();
		Bard bard3 = (Bard) context.getBean("bard2");
		bard3.singing();
		context.close();
	}
}