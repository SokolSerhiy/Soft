package ua.dao;

import java.util.List;

import ua.entity.Message;

public interface MessageDao {

	List<Message> findAll();
}
