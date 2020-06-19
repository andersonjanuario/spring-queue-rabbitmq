package org.spring.queue.listeners;

import lombok.extern.slf4j.Slf4j;
import org.spring.queue.constants.ConstantsMq;
import org.spring.queue.domain.QueueObj;
import org.spring.queue.service.QueueService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueListener {

    @Autowired
    private QueueService serviceQueue;

    @RabbitListener(queues = ConstantsMq.ROUTING_KEY, errorHandler="rabbitExceptionHandler")
    public void orderReceived(@Payload QueueObj body) {
        log.info("message received");
        serviceQueue.callQueue(body);
    }

    @RabbitListener(queues = ConstantsMq.ROUTING_KEY_DEAD, errorHandler="rabbitExceptionHandler")
    public void orderReceivedDead(String body) {
        log.info("message error received - start");
        log.error("message :{}",body);
        log.info("message error received - end");
    }

}
