package com.greeting;


import static org.hamcrest.Matchers.equalTo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.greeting.controller.GreetingController;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GreetingRestApplication.class)
@WebAppConfiguration
public class GreetingRestApplicationTests {
    @Before
    public void setUp(){
    	  RestAssuredMockMvc.standaloneSetup(new GreetingController());
    }
	@Test
	public void testGreeting() {
		RestAssuredMockMvc.given().
		when().
		   get("/GreetingRest/greeting").
	    then().
	       body("message", equalTo("Hello World"));
	}

}
