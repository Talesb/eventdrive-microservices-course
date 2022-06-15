package com.talesb.microservices.kafka.admin.config.exception;

public class KafkaClientException extends RuntimeException {

	public KafkaClientException() {
		super();
	}

	public KafkaClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public KafkaClientException(String message) {
		super(message);
	}

	
	
}
