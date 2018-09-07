package org.spring.queue.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class ControllerQueue.
 */
@RestController
public class ControllerQueue {
	
	/** The service. */
	@Autowired
	ServiceQueue service;
	
	/**
	 * Call queue.
	 *
	 * @return the response entity
	 */
	@GetMapping(value = "call")
	public ResponseEntity<String> callQueue(){
		return ResponseEntity.status(HttpStatus.OK).body(service.callQueue());
	}
}
