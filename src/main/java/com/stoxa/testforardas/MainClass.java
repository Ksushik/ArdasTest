/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author stoxa
 */
public class MainClass {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Greeting myGreeting = (Greeting) context.getBean("greeting");
        System.out.println(myGreeting.getMessage());

    }
}
