package com.talesb.microservices.twittertokafka.runner;

import twitter4j.TwitterException;

public interface StreamRunner {

	public void start() throws TwitterException;

}
