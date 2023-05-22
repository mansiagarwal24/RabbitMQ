package com.rabbitMQ.rabbitMq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {
    @Autowired
    private DirectExchange exchange;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("sendMessage")
    public String sendMessage(@RequestBody Message message){
        rabbitTemplate.convertAndSend(exchange.getName(),"routing.A",message);
        return "Message sent successfully!!";
    }
}
