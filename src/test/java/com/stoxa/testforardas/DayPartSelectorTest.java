package com.stoxa.testforardas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ksu
 */
public class DayPartSelectorTest extends DayPartSelector {

    private int currentHourOfDay;
    private Calendar todaysCalendar;

    public String getKeyMessage(Calendar c) {
        currentHourOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (currentHourOfDay > 6 && currentHourOfDay <= 9) {
            return "MorningMessage";
        }
        if (currentHourOfDay > 9 && currentHourOfDay <= 19) {
            return "DayMessage";
        }
        if (currentHourOfDay > 19 && currentHourOfDay <= 23) {
            return "EveningMessage";
        } else {
            return "NightMessage";
        }
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
     * Test of getTypeMessage method, of class DayPartSelector.
     */
    @Test
    public void test1GetKeyMessage() {
        System.out.println("Test1: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 8, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest();
        String expResult = "MorningMessage";
        String result = instance.getKeyMessage(todaysCalendar);
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test1 passed correctly (morning)");
        } else {
            fail("The test1 was failed (morning)");
        }
    }

    @Test
    public void test2GetKeyMessage() {
        System.out.println("Test2: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 12, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest();
        String expResult = "DayMessage";
        String result = instance.getKeyMessage(todaysCalendar);
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test2 passed correctly (day)");
        } else {
            fail("The test2 was failed (day)");
        }
    }

    @Test
    public void test3GetKeyMessage() {
        System.out.println("Test3: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 20, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest();
        String expResult = "EveningMessage";
        String result = instance.getKeyMessage(todaysCalendar);
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test3 passed correctly (evening)");
        } else {
            fail("The test3 was failed (evening)");
        }
    }

    @Test
    public void test4GetKeyMessage() {
        System.out.println("Test4: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 0, 15);
        DayPartSelectorTest instance = new DayPartSelectorTest();
        String expResult = "NightMessage";
        String result = instance.getKeyMessage(todaysCalendar);
        if (expResult.equalsIgnoreCase(result)) {
            System.out.println("Test4 passed correctly (night)");
        } else {
            fail("The test4 was failed (night)");
        }
    }

}
