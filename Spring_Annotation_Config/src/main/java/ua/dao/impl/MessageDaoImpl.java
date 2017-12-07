package ua.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import ua.annotation.MessageQualifier;
import ua.dao.MessageDao;
import ua.entity.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	public List<Message> findAll() {
		System.out.println("Find in DB");
		return Collections.emptyList();
	}

}