package com.coder.deploy.util;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public long millisecondsToSeconds(long milliseconds) {
		return TimeUnit.MILLISECONDS.toSeconds(milliseconds);
	}

}
