package org.spring.queue.service;
import lombok.extern.slf4j.Slf4j;
import org.spring.queue.domain.QueueObj;
import org.spring.queue.publishers.QueuePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@Service
public class QueueServiceImpl implements QueueService {

	@Autowired
	private QueuePublisher publisher;

	@Override
	public void callQueue(QueueObj body) {
		mountQueueObj(body);
		log.info("message received - body:{} processing...",body);
		publisher.sendQueue(body);
	}

	private void mountQueueObj(QueueObj body) {
		body.setCode(body.getCode()+1l);
		body.setPeriod(getPeriod());
		try {
			Thread.sleep (2000);
		} catch (InterruptedException e) {
			log.info("error while call thread.sleep, error:{}", e.getMessage());
		}
	}

	private String getPeriod(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssmmm");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(new Date());
	}

}
