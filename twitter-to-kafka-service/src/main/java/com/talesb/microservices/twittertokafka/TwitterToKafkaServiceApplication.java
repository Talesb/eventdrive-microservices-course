package com.talesb.microservices.twittertokafka;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.talesb.microservices.conf.TwitterToKafkaServiceConfigData;
import com.talesb.microservices.twittertokafka.runner.StreamRunner;

@SpringBootApplication
@ComponentScan("com.talesb.microservices")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

	@Autowired
	private TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;
	
	@Autowired
	private StreamRunner streamRunner;

	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("App is starting..");
		LOG.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[] {})));
		LOG.info(twitterToKafkaServiceConfigData.getWelcomeMessage());
		streamRunner.start();
	}

}
