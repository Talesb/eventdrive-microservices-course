package com.talesb.microservices.kafka.admin.config.client;

import org.apache.kafka.clients.admin.AdminClient;
import org.slf4j.Logger;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import com.talesb.microservices.conf.KafkaConfigData;
import com.talesb.microservices.conf.RetryConfigData;

import org.slf4j.LoggerFactory;

@Component
public class KafkaAdminClient {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminClient.class);

	private final KafkaConfigData kafkaConfigData;

	private final RetryConfigData retryConfigData;

	private final AdminClient adminClient;

	private final RetryTemplate retryTemplate;

	public KafkaAdminClient(KafkaConfigData kafkaConfigData, RetryConfigData retryConfigData, AdminClient adminClient,
			RetryTemplate retryTemplate) {
		this.kafkaConfigData = kafkaConfigData;
		this.retryConfigData = retryConfigData;
		this.adminClient = adminClient;
		this.retryTemplate = retryTemplate;
	}

}
