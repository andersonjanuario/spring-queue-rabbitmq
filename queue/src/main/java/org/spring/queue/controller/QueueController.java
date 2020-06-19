package org.spring.queue.controller;

import lombok.extern.slf4j.Slf4j;
import org.spring.queue.domain.QueueObj;
import org.spring.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class QueueController {
	
	@Autowired
	QueueService service;
	
	@PostMapping(value = "call")
	public ResponseEntity<Void> callQueue(@Valid @RequestBody QueueObj body) throws InterruptedException {
		log.info("message called");
		service.callQueue(body);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
