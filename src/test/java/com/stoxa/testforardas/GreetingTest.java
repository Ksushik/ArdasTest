/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;

import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stoxa
 */
public class GreetingTest {
    
    public GreetingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start of class Greeting testing");
    }
    
    @AfterClass
    public static void tearDownClass() {
         System.out.println("The end of class Greeting testing");
         System.out.println("*********************************************************");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println("--------------------------------------------");
    }

    /**
     * Test of localizeMessage method, of class Greeting.
     */
    @Test
    public void test1LocalizeMessage() {
        System.out.println("Test1: Let's test the method localizeMessage for Morning");
        String keyMessage = "MorningMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("en", "US");
        String expResult = "Good morning, World!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test1 passed correctly");
        } else {
        fail("The test1 was failed");
        }
    }
    
     @Test
    public void test2LocalizeMessage() {
        System.out.println("Test1: Let's test the method localizeMessage for Day");
        String keyMessage = "DayMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("en", "US");
        String expResult = "Good day, World!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test2 passed correctly");
        } else {
        fail("The test2 was failed");
        }
    }
    
     @Test
    public void test3LocalizeMessage() {
        System.out.println("Test3: Let's test the method localizeMessage for Evening");
        String keyMessage = "EveningMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("en", "US");
        String expResult = "Good evening, World!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test3 passed correctly");
        } else {
        fail("The test3 was failed");
        }
    }
    
    @Test
    public void test4LocalizeMessage() {
        System.out.println("Test4: Let's test the method localizeMessage for Night");
        String keyMessage = "NightMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("en", "US");
        String expResult = "Good night, World!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test4 passed correctly");
        } else {
        fail("The test4 was failed");
        }
    }
    
    @Test
    public void test5LocalizeMessage() {
        System.out.println("Test5: Let's test the method localizeMessage for Morning");
        String keyMessage = "MorningMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("ru", "UA");
        String expResult = "Доброе утро, Мир!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test5 passed correctly");
        } else {
        fail("The test5 was failed");
        }
    }
    
    @Test
    public void test6LocalizeMessage() {
        System.out.println("Test6: Let's test the method localizeMessage for Day");
        String keyMessage = "DayMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("ru", "UA");
        String expResult = "Добрый день, Мир!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test6 passed correctly");
        } else {
        fail("The test6 was failed");
        }
    }
    
    @Test
    public void test7LocalizeMessage() {
        System.out.println("Test7: Let's test the method localizeMessage for Evening");
        String keyMessage = "EveningMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("ru", "UA");
        String expResult = "Добрый вечер, Мир!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test7 passed correctly");
        } else {
        fail("The test7 was failed");
        }
    }
    
    @Test
    public void test8LocalizeMessage() {
        System.out.println("Test8: Let's test the method localizeMessage for Night");
        String keyMessage = "NightMessage";
        Greeting instance = new Greeting();
        Locale locale = new Locale("ru", "UA");
        String expResult = "Доброй ночи, Мир!";
        String result = instance.localizeMessage(keyMessage,locale);
        if (expResult.equalsIgnoreCase(result)){
        System.out.println("Test8 passed correctly");
        } else {
        fail("The test8 was failed");
        }
    }
}
