/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syniaeva.greeter;

import com.syniaeva.greeter.Greeting;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
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
 * @author syniaeva
 */
public class GreetingTest {

    private String baseName;
    private ResourceBundle bundle;
    public static Locale locale;
    private String message;
    final Logger logger;
    private Greeting instance;

    public GreetingTest() {
        logger = LoggerFactory.getLogger(GreetingTest.class);
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
        Locale locale = new Locale("en", "US");
        prepareInstance(keyMessage, locale);
        String expResult = "Good morning, World!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test1 passed correctly");
        } else {
            fail("The test1 was failed");
        }
    }

    @Test
    public void test2LocalizeMessage() {
        System.out.println("Test1: Let's test the method localizeMessage for Day");
        String keyMessage = "DayMessage";
        Locale locale = new Locale("en", "US");
        prepareInstance(keyMessage, locale);
        String expResult = "Good day, World!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test2 passed correctly");
        } else {
            fail("The test2 was failed");
        }
    }

    @Test
    public void test3LocalizeMessage() {
        System.out.println("Test3: Let's test the method localizeMessage for Evening");
        String keyMessage = "EveningMessage";
        Locale locale = new Locale("en", "US");
        prepareInstance(keyMessage, locale);
        String expResult = "Good evening, World!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test3 passed correctly");
        } else {
            fail("The test3 was failed");
        }
    }

    @Test
    public void test4LocalizeMessage() {
        System.out.println("Test4: Let's test the method localizeMessage for Night");
        String keyMessage = "NightMessage";
        Locale locale = new Locale("en", "US");
        prepareInstance(keyMessage, locale);
        String expResult = "Good night, World!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test4 passed correctly");
        } else {
            fail("The test4 was failed");
        }
    }

    @Test
    public void test5LocalizeMessage() {
        System.out.println("Test5: Let's test the method localizeMessage for Morning");
        String keyMessage = "MorningMessage";
        Locale locale = new Locale("ru", "UA");
        prepareInstance(keyMessage, locale);
        String expResult = "Доброе утро, Мир!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test5 passed correctly");
        } else {
            fail("The test5 was failed");
        }
    }

    @Test
    public void test6LocalizeMessage() {
        System.out.println("Test6: Let's test the method localizeMessage for Day");
        String keyMessage = "DayMessage";
        Locale locale = new Locale("ru", "UA");
        prepareInstance(keyMessage, locale);
        String expResult = "Добрый день, Мир!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test6 passed correctly");
        } else {
            fail("The test6 was failed");
        }
    }

    @Test
    public void test7LocalizeMessage() {
        System.out.println("Test7: Let's test the method localizeMessage for Evening");
        String keyMessage = "EveningMessage";
        Locale locale = new Locale("ru", "UA");
        prepareInstance(keyMessage, locale);
        String expResult = "Добрый вечер, Мир!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test7 passed correctly");
        } else {
            fail("The test7 was failed");
        }
    }

    @Test
    public void test8LocalizeMessage() {
        System.out.println("Test8: Let's test the method localizeMessage for Night");
        String keyMessage = "NightMessage";
        Locale locale = new Locale("ru", "UA");
        prepareInstance(keyMessage, locale);
        String expResult = "Доброй ночи, Мир!";
        String result = instance.getMessage();
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test8 passed correctly");
        } else {
            fail("The test8 was failed");
        }
    }

    private void prepareInstance(String keyMessage, Locale locale) {
        instance = new Greeting(locale);
        try {
            Field keyM = instance.getClass().getDeclaredField("keyMessage");
            keyM.setAccessible(true);
            keyM.set(instance, keyMessage);
        } catch (NoSuchFieldException | SecurityException ex) {
            logger.error("Enable to get Field keyMessage: ", ex);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            logger.error("Enable to change Field keyMessage: ", ex);
        }
    }
}
