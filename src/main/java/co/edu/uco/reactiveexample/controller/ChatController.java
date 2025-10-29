package co.edu.uco.reactiveexample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@MessageMapping("/public-message")
	@SendTo("/topic/public-chat")
	public ChatResponseDTO notifyNewMessage(ChatRequestDTO request) {
		var dateTime = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").format(new Date());
		return new ChatResponseDTO(request.message(), dateTime);
	}
	
	@MessageMapping("/connect-user")
	@SendToUser("/topic/connect-users")
	public String connect(SimpMessageHeaderAccessor sessionInformation) {
		return "User connected successfully whith session id: " + sessionInformation.getSessionId();
	}
	
}
