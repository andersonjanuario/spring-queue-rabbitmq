package org.spring.queue.example;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class Receiver.
 */
@Component
public class Receiver {

    /** The latch. */
    private CountDownLatch latch = new CountDownLatch(1);
    
    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);


    /**
     * Receive message.
     *
     * @param obj the obj
     */
    public void receiveMessage(QueueObj obj) {
    	for(long i=1000000;i> 1;i--){
    		logger.info("wait for the countdown count:{}", i);
    	}
        logger.info("completed...");
        latch.countDown();
    }

    /**
     * Gets the latch.
     *
     * @return the latch
     */
    public CountDownLatch getLatch() {
        return latch;
    }

}