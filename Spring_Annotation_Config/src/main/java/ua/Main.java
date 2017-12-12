package ua;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import ua.controller.MessageController;
import ua.dao.MessageDao;
import ua.dao.impl.MessageDaoImpl;
import ua.service.MessageService;
import ua.service.impl.MessageServiceImpl;

@Configuration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		MessageController controller = context.getBean(MessageController.class);
		controller.readMessagesForUser();
		context.close();
	}
	
//	@Bean
//	MessageDao messageDao() {
//		return new MessageDaoImpl();
//	}
//	
//	@Bean
//	MessageService messageService() {
//		return new MessageServiceImpl(messageDao());
//	}
//	
//	@Bean
//	MessageController messageController() {
//		return new MessageController(messageService());
//	}
}
