package org.spring.queue.exceptions;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;

public class RabbitExceptionHandler  implements RabbitListenerErrorHandler {

    @Override
    public Object handleError(Message message, org.springframework.messaging.Message<?> message1, ListenerExecutionFailedException e) throws Exception {
        return null;
    }
}
