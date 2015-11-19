/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author stoxa
 */
public class GreetingTest {
    String baseName;
    private ResourceBundle bundle; 
    public static Locale locale; 
    String message; 
    final Logger logger;
    
    public GreetingTest() {
        logger = LoggerFactory.getLogger(Greeting.class);
    }
    private String getBaseName (Locale locale) {
     if (locale.getLanguage().equalsIgnoreCase("ru")) {
         baseName = "text_ru";
     }
     else {
         baseName = "text";
     }
    
     return baseName;
     }
    // for test
  public String  localizeMessage (String keyMessage, Locale locale) { 
     baseName = getBaseName(locale);
   try {
   bundle = ResourceBundle.getBundle(baseName, locale);
   } catch (MissingResourceException ex1) 
   {
       logger.error("No resource bundle for the specified base name can be found, "
               + "perhaps you should specify the full path to the file: ", ex1);
   }catch (NullPointerException ex2) {
       logger.error("baseName is null: ", ex2);
   }

   try {
   message = bundle.getString(keyMessage);
   } catch (MissingResourceException ex3) 
   {
       logger.error("No object for the given key can be found, " + ex3.getStackTrace(), ex3);
    } catch (NullPointerException ex4) {
       logger.error("key is null: keyMessage = "+ keyMessage, ex4);
    }  catch (ClassCastException ex5) {
       logger.error("The object found for the given key is not a string: keyMessage = " +
               keyMessage + ", message = " + message , ex5);
   }
   logger.info("The metod localizeMessage returned message = " + message);
return message;
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
        GreetingTest instance = new GreetingTest();
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
