package com.coder.deploy.controller;

import static io.restassured.RestAssured.given;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.coder.deploy.security.jwt.AccountCredentials;
import com.google.gson.Gson;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JWTControllerTokenTests {

	private final String URL_API = "/token";
	private final String URL_LOGIN = "/oauth/login";
	private final String SECRET = "MinhaPalavraChave";
	private final long EXPIRATION_TIME = 120000;
	private StringBuilder jwt = new StringBuilder();
	private Gson gson;
	
	@LocalServerPort
	int port;
	
    @Before
    public void setUp() {
        RestAssured.port = port;
        String jwtGenerated = Jwts.builder()
                .setSubject("teste")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        jwt.append("Bearer ");
        jwt.append(jwtGenerated);
        gson = new Gson();
    }

    @Test
    public void getTokenGetTest() {
    	given().headers("Authorization",jwt.toString(),"Content-Type",
                ContentType.TEXT, "Accept", ContentType.TEXT)
    						.when().get(URL_API).then().statusCode(200);
    }
    
    @Test
    public void loginTokenForbiddenTest() {
    	AccountCredentials accountCredentials = new AccountCredentials();
    	accountCredentials.setUsername("teste");
    	accountCredentials.setPassword("xxx");
    	
    	given().contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(gson.toJson(accountCredentials))
			.when().post(URL_LOGIN)
			.then()
			    .statusCode(403);
    }
    
    @Test
    public void loginTokenSuccessTest() {
    	AccountCredentials accountCredentials = new AccountCredentials();
    	accountCredentials.setUsername("admin");
    	accountCredentials.setPassword("password");
    	
    	given().contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(gson.toJson(accountCredentials))
			.when().post(URL_LOGIN)
			.then()
			    .statusCode(200);
    }
    
   
	
}
