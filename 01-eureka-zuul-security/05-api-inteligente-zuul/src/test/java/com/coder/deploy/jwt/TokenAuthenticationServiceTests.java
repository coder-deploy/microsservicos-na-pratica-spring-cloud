package com.coder.deploy.jwt;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.coder.deploy.security.jwt.TokenAuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RunWith(SpringRunner.class)
public class TokenAuthenticationServiceTests {

	private TokenAuthenticationService tokenAuthenticationService = new TokenAuthenticationService();
	
	private StringBuilder jwt = new StringBuilder();
	private final String SECRET = "MinhaPalavraChave";
	private final long EXPIRATION_TIME = 120000;
	
    @Before
    public void setUp() {
        String jwtGenerated = Jwts.builder()
                .setSubject("teste")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        jwt.append("Bearer ");
        jwt.append(jwtGenerated);
        System.out.println(jwt);
    }

    @Test
    public void getTokenGetTest() {
    	//tokenAuthenticationService.
    }
}
