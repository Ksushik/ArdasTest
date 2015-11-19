/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;

import static com.stoxa.testforardas.Greeting.locale;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author stoxa
 */
public class MainClass {
    public static void main(String[] args) {
        Greeting myGreeting = new Greeting();
        GreetingType keyMessage = new GreetingType();
        String key = keyMessage.determineKeyMessage();
        System.out.println(myGreeting.localizeMessage(key));

    }
}
