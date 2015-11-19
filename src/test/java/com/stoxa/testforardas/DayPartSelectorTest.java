/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class DayPartSelectorTest extends DayPartSelector {
   
    
    public DayPartSelectorTest(Calendar calendarForTest) {
    c = calendarForTest;   
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start of class GreetingType testing");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("The end of class GreetingType testing");
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
     * Test of getKeyMessage method, of class DayPartSelector.
     */
    @Test
    public void test1GetKeyMessage() {
        System.out.println("Test1: Let's test the method determineKeyMessage");
        c=new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 8, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest(c);
        String expResult = "MorningMessage";
        String result = instance.getKeyMessage();
        if (expResult.equalsIgnoreCase(result)){
        System.out.println ("Test1 passed correctly (morning)");
        } else {
        fail("The test1 was failed (morning)");
        }
    }
    
    @Test
    public void test2GetKeyMessage() {
        System.out.println("Test2: Let's test the method determineKeyMessage");
        c=new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 12, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest(c);
        String expResult = "DayMessage";
        String result = instance.getKeyMessage();
        if (expResult.equalsIgnoreCase(result)){
        System.out.println ("Test2 passed correctly (day)");
        } else {
        fail("The test2 was failed (day)");
        }
    }
    
    @Test
    public void test3GetKeyMessage() {
        System.out.println("Test3: Let's test the method determineKeyMessage");
        c=new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 20, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest(c);
        String expResult = "EveningMessage";
        String result = instance.getKeyMessage();
        if (expResult.equalsIgnoreCase(result)){
        System.out.println ("Test3 passed correctly (evening)");
        } else {
        fail("The test3 was failed (evening)");
        }
    }
    
    @Test
    public void test4GetKeyMessage() {
        System.out.println("Test4: Let's test the method determineKeyMessage");
        c=new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 0, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest(c);
        String expResult = "NightMessage";
        String result = instance.getKeyMessage();
        if (expResult.equalsIgnoreCase(result)){
        System.out.println ("Test4 passed correctly (night)");
        } else {
        fail("The test4 was failed (night)");
        }
    }
    
}
