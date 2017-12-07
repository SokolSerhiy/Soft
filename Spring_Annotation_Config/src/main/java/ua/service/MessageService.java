package ua.service;

import java.util.List;

import ua.entity.Message;

public interface MessageService {

	List<Message> getAllForUser(String username);
}
