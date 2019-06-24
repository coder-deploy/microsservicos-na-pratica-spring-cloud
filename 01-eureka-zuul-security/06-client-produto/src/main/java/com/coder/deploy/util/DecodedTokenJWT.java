package com.coder.deploy.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DecodedTokenJWT {

	  public String sub;
	  public long exp;

	  public DecodedTokenJWT getDecoded(String encodedToken) throws UnsupportedEncodingException {
	      String[] pieces = encodedToken.split("\\.");
	      String body = pieces[1];
		  String unencoded = new String(Base64.decodeBase64(body), "UTF-8");
		  Map<Object, String> data = new HashMap<>();
		  data.put("JWT", unencoded);
	      return new Gson().fromJson(data.get("JWT"), DecodedTokenJWT.class);
	  }

	  public String toString() {
	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
	      return gson.toJson(this);
	  }

	}