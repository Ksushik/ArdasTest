package com.syniaeva.greeter;

import com.syniaeva.greeter.DayPartSelector;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ksu
 */
public class DayPartSelectorTest {

    private int currentHourOfDay;
    private Calendar todaysCalendar;
    private DayPartSelector instance;
    private Field calendar;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(DayPartSelector.class);

   


    @Before
    public void setUp() {
        instance = new DayPartSelector();
        try {
            calendar = instance.getClass().getDeclaredField("todaysCalendar");
            calendar.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException ex) {
            logger.error("Enable to get Field todaysCalendar: ", ex);
        }
    }

    @After
    public void tearDown() {
        logger.debug("--------------------------------------------");
    }

    /**
     * Test of getTypeMessage method, of class DayPartSelector.
     */
    @Test
    public void test1GetKeyMessage() {
        logger.debug("Test1: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 8, 15);
        try {
            calendar.set(instance, todaysCalendar);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            logger.error("Enable to set current date: ",ex);
        }
        String expResult = "MorningMessage";
        String result = instance.getTypeMessage();
        if (expResult.equalsIgnoreCase(result)) {
            logger.debug("Test1 passed correctly (morning)");
        } else {
            fail("The test1 was failed (morning)");
        }
    }

    @Test
    public void test2GetKeyMessage() {
        logger.debug("Test2: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 12, 15);
        try {
            calendar.set(instance, todaysCalendar);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            logger.error("Enable to set current date: ",ex);
        }
        String expResult = "DayMessage";
        String result = instance.getTypeMessage();
        if (expResult.equalsIgnoreCase(result)) {
            logger.debug("Test2 passed correctly (day)");
        } else {
            fail("The test2 was failed (day)");
        }
    }

    @Test
    public void test3GetKeyMessage() {
        logger.debug("Test3: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 20, 15);
        try {
            calendar.set(instance, todaysCalendar);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            logger.error("Enable to set current date: ",ex);
        }
        String expResult = "EveningMessage";
        String result = instance.getTypeMessage();
        if (expResult.equalsIgnoreCase(result)) {
            logger.debug("Test3 passed correctly (evening)");
        } else {
            fail("The test3 was failed (evening)");
        }
    }

    @Test
    public void test4GetKeyMessage() {
        logger.debug("Test4: Let's test the method determineKeyMessage");
        todaysCalendar = new GregorianCalendar(2015, Calendar.NOVEMBER, 18, 0, 15);
        try {
            calendar.set(instance, todaysCalendar);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            logger.error("Enable to set current date: ",ex);
        }
        String expResult = "NightMessage";
        String result = instance.getTypeMessage();
        if (expResult.equalsIgnoreCase(result)) {
            logger.debug("Test4 passed correctly (night)");
        } else {
            fail("The test4 was failed (night)");
        }
    }

}
