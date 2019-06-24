package com.coder.deploy.util;

import java.io.UnsupportedEncodingException;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Util {
	
	private static final Logger logger = LoggerFactory.getLogger(Util.class);
	
	public long millisecondsToSeconds(long milliseconds) {
		return TimeUnit.MILLISECONDS.toSeconds(milliseconds);
	}

	public void validationToken(String token) throws UnsupportedEncodingException, AccessDeniedException {
		DecodedTokenJWT tokenDecoded = new DecodedTokenJWT().getDecoded(token);
		logger.warn("User logado: " + tokenDecoded.sub);
		logger.warn("Exp: " + tokenDecoded.exp);
		if (tokenDecoded.exp < millisecondsToSeconds(new Date().getTime())) {
			logger.error("É necessário conectar");
			throw new AccessDeniedException("É necessário conectar!");
		}
	}
	
}
