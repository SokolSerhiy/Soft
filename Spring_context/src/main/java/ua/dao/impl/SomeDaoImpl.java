package ua.dao.impl;

import org.springframework.stereotype.Repository;

import ua.annotation.UserTransactional;
import ua.dao.SomeDao;

@Repository
public class SomeDaoImpl implements SomeDao {
	
//	@Autowired
//	private SomeDao someDao;
	
	private static int count = 0;
	
	public SomeDaoImpl() {
		System.out.println("In constructor");
		count++;
	}

	//read
	@UserTransactional
	public void method1() {
		System.out.println("method1()");
	}
	
	//write
	@UserTransactional
	public void method2() {
		System.out.println("method2()");
	}

	public void init() {
		System.out.println("init()");
		method2();
	}

	@Override
	protected void finalize() throws Throwable {
		count--;
	}
}
