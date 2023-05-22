package com.rabbitMQ.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    @RabbitListener(queues = "queue.A")
    private void receiveMessage(Message message){
        log.info("Message recieved from Queue-A->{}",message);
    }

    @RabbitListener(queues = "queue.B")
    private void receiveMsgFromB(Message message){
        log.info("Message recieved from Queue-B->{}",message);
    }
}
