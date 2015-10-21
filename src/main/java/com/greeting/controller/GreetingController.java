package com.greeting.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.modelo.Greeting;
@RequestMapping("GreetingRest")
@RestController
public class GreetingController {
	Greeting greeting = new Greeting("Hello World");
	
@RequestMapping(value = "/greeting", method = GET, produces = { APPLICATION_JSON_VALUE })
@ResponseBody
 public  Greeting greeting(){
	 return greeting;
 }
}
