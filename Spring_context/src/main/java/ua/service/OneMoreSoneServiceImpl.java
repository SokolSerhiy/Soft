package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.annotation.UserTransactional;
import ua.dao.SomeDao;

@Service
public class OneMoreSoneServiceImpl implements OneMoreSoneService{
	
	@Autowired
	private SomeDao dao;

	@UserTransactional
	public void some() {
		dao.method1();
		dao.method2();
	}

}
