package ua.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ua.dao.SomeDao;

@Component
public class WarmCache implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SomeDao dao;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		dao.init();
	}
}