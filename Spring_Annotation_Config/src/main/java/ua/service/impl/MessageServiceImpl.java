package ua.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.annotation.MessageQualifier;
import ua.dao.MessageDao;
import ua.entity.Message;
import ua.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	private MessageDao dao;
	
	@Autowired
	public MessageServiceImpl(MessageDao dao) {
		this.dao = dao;
	}

	public List<Message> getAllForUser(String username) {
		List<Message> messages = dao.findAll().stream().filter(e->true).collect(Collectors.toList());
		System.out.println("Process messages for user "+username);
		return messages;
	}

}
