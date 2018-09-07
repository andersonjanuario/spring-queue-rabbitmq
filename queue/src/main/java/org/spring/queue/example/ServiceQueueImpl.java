package org.spring.queue.example;
import org.spring.queue.QueueApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class ServiceQueueImpl.
 */
@Service
public class ServiceQueueImpl implements ServiceQueue {

	/** The rabbit template. */
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	/* (non-Javadoc)
	 * @see org.spring.queue.example.ServiceQueue#callQueue()
	 */
	@Override
	public String callQueue() {
        rabbitTemplate.convertAndSend(QueueApplication.TOPIC_EXCHANGE_NAME, "spring.queue.example", new QueueObj(1,"deibson anderson",34));
        return "Sending message...";
	}

}
