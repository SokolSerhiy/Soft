package ua.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dao.SomeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/META-INF/applicationContext.xml")
public class SomeServiceTest {
	
	@Autowired
	private SomeDao dao;
	
	@Autowired
	private OneMoreSoneService service;

	@Test
	public void sometest() {
		System.out.println("Test");
		dao.method1();
		dao.method2();
		System.out.println("---------------------------");
		service.some();
	}
}
