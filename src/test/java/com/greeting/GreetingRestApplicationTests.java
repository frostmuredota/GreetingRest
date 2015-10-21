package com.greeting;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.greeting.controller.GreetingController;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GreetingRestApplication.class)
@WebAppConfiguration
public class GreetingRestApplicationTests {
    private MockMvc mvc;
    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
        RestAssuredMockMvc.standaloneSetup(new GreetingController());
    }
	@Test
	public void testGetGreeting() {
		RestAssuredMockMvc.given().
		when().
		   get("/GreetingRest/get/{id}",0).
	    then().
	       statusCode(200).
	       body("message", equalTo("Hello World"));
	}
	@Test
	public void testNormalGetGreeting()throws Exception{
	    mvc.perform(
                get("/GreetingRest/get/{id}",0).accept(
                        MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello World"));
	}
	@Test
    public void testDeleteGreeting() {
        RestAssuredMockMvc.
        given().
           contentType(ContentType.JSON).
        when().
           delete("/GreetingRest/delete/{id}",0).
        then().
           statusCode(200).
           body("message", equalTo("Hello World"));
    }
	@Test
    public void testNormalDeleteGreeting()throws Exception{
        mvc.perform(
                delete("/GreetingRest/delete/{id}",0).accept(
                        MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello World"));
    }
	
	

}
