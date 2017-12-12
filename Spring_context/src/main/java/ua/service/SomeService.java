package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.dao.SomeDao;

@Service
public class SomeService {
	
	@Autowired
	private SomeDao dao;

	public void one() {
		dao.method1();
	}
	
	public void two() {
		dao.method2();
	}
}
