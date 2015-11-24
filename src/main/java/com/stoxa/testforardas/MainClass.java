/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;

/**
 *
 * @author stoxa
 */
public class MainClass {
    public static void main(String[] args) {
        Greeting myGreeting = new Greeting();
        DayPartSelector keyMessage = new DayPartSelector();
        String key = keyMessage.getTypeMessage();
        System.out.println(myGreeting.getMessage(key));

    }
}
