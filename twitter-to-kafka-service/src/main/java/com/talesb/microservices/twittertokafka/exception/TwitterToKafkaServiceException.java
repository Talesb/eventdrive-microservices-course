package com.talesb.microservices.twittertokafka.exception;

public class TwitterToKafkaServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TwitterToKafkaServiceException() {
		super();
	}

	public TwitterToKafkaServiceException(String message) {
		super(message);
	}

	public TwitterToKafkaServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
