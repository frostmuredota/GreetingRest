package com.greeting.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.modelo.Greeting;
@RequestMapping("GreetingRest")
@RestController
public class GreetingController {
    Greeting greeting ;
    Greeting greeting1;
    Greeting greeting2 ;
    List<Greeting> mygreetings;
    
    public GreetingController(){
        greeting = new Greeting("Hello World");
        greeting1= new Greeting("Hello Nisum");
        greeting2= new Greeting("Bye Nisum");
        mygreetings = new ArrayList<Greeting>();
        mygreetings.add(greeting);
        mygreetings.add(greeting1);
        mygreetings.add(greeting2);
    }

	
    @RequestMapping(value = "/get/{id}", method = GET, produces = { APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<Greeting> getGreeting(@PathVariable("id") int id) {
        if(mygreetings.size()-1 < id){
            return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Greeting>(mygreetings.get(id),
                    HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/delete/{id}", method = DELETE, produces = { APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") int id) {
        if(mygreetings.size()-1 < id){
            return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Greeting>(mygreetings.remove(id),
                    HttpStatus.OK);
        }
    }
}
