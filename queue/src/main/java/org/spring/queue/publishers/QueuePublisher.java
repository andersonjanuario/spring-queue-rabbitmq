package org.spring.queue.publishers;

import lombok.extern.slf4j.Slf4j;
import org.spring.queue.constants.ConstantsMq;
import org.spring.queue.domain.QueueObj;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueuePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendQueue(QueueObj body) {
        try {
            this.rabbitTemplate.convertAndSend(ConstantsMq.EXCHANGE, ConstantsMq.ROUTING_KEY, body);
            log.info("message sended.");
        } catch (AmqpException ex) {
            log.error("sendQueue - Error:{} - Payload: {} ", ex.getMessage(), body, ex);
            throw ex;
        }
    }



}


