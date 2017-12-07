package ua.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import ua.service.MessageService;

@Controller
public class MessageController {

	private MessageService service;
	
	public MessageController(MessageService service) {
		this.service = service;
	}

	public void readMessagesForUser() {
		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		scanner.close();
		System.out.println(service.getAllForUser(username));
	}
}
