package ua.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import ua.dao.MessageDao;
import ua.entity.Message;

@Repository
public class MessageDao2 implements MessageDao{

	@Override
	public List<Message> findAll() {
		System.out.println("MessageDao2");
		return Collections.emptyList();
	}

}
