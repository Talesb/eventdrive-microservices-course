package com.talesb.microservices.twittertokafka.runner.impl;

import java.util.Arrays;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.talesb.microservices.conf.TwitterToKafkaServiceConfigData;
import com.talesb.microservices.twittertokafka.listener.TwitterKafkaStatusListener;
import com.talesb.microservices.twittertokafka.runner.StreamRunner;

import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Component
@ConditionalOnProperty(name="twitter-to-kafka-service.enable-mock-tweets",havingValue="false",matchIfMissing = true)
public class TwitterKafkaStreamRunner implements StreamRunner {

	private TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;

	private TwitterKafkaStatusListener twitterKafkaStatusListener;

	private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);

	private TwitterStream twitterStream;

	public TwitterKafkaStreamRunner(TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData,
			TwitterKafkaStatusListener twitterKafkaStatusListener) {
		this.twitterToKafkaServiceConfigData = twitterToKafkaServiceConfigData;
		this.twitterKafkaStatusListener = twitterKafkaStatusListener;
	}

	@Override
	public void start() throws TwitterException {
		twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.addListener(twitterKafkaStatusListener);
		addFilter();
	}

	private void addFilter() {
		String[] keywords = twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[0]);
		FilterQuery filterQuery = new FilterQuery(keywords);
		twitterStream.filter(filterQuery);
		LOG.info("Starting to add filter to strings : ", Arrays.toString(keywords));
	}

	@PreDestroy
	public void shutDown() {
		if (twitterStream != null) {
			LOG.info("Closing twitter streams");
			twitterStream.shutdown();
		}
	}

}
