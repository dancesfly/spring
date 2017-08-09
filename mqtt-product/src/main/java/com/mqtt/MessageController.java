package com.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("/mqtt")  
public class MessageController {  
    @Autowired 
    private MqttPahoMessageHandler mqtt;  
      
    @RequestMapping(value="/send")
    @ResponseBody
    public void sendMessage(){  
    	Message<String> message = MessageBuilder.withPayload("==========1111111111111111111111111=========").setHeader(MqttHeaders.TOPIC, "myqueue").build();  
    	mqtt.handleMessage(message);
    	
    	System.out.println("³É¹¦");  
    }  
}  
