/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syniaeva.testforardas.controller;

import com.syniaeva.testforardas.Greeting;
import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author syniaeva
 */

@Path("/")
public class GreetingController {
    

    private Greeting myGreeting;
    
    @GET
    public String greet() {
        myGreeting = new Greeting();
        return myGreeting.getMessage();
    }
    
    @GET
    @Path("/en")
    public String greetEn() {
        myGreeting = new Greeting(Locale.ENGLISH);
        return myGreeting.getMessage();
    }
    
    @GET
    @Path("/ru")
    @Produces (MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String greetRu() {
        myGreeting = new Greeting(new Locale("ru", "RU"));
        return myGreeting.getMessage();
    }
    
}
