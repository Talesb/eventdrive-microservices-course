package com.talesb.microservices.twittertokafka.conf;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "twitter-to-kafka-service")
@Configuration
public class TwitterToKafkaServiceConfigData {

	private List<String> twitterKeywords;
	private String welcomeMessage;
	private Boolean enableMockTweets;
	private Long mockSleepMs;
	private Integer mockMinTweetLength;
	private Integer mockMaxTweetLength;
}
