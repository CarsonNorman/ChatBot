package com.carson.chatbot.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.carson.chatbot.domain.ChatBotMessage;

@Controller
public class ChatBotController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/javainuse")
    public ChatBotMessage newUser(@Payload ChatBotMessage chatBotMessage){
        return chatBotMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("topic/javainuse")
    public ChatBotMessage newUser(@Payload ChatBotMessage chatBotMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatBotMessage.getSender());
        return chatBotMessage;
    }
}
