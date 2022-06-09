package com.talesb.microservices.conf;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-config")
public class KafkaConfigData {

	private String bootstrapServers;
	private String schemaRegistryUrlKeys;
	private String schemaRegistryUrl;
	private String topicName;
	private List<String> topicNamesToCreate;
	private Integer numOfPartitions;
	private Short replicationFactor;

}
