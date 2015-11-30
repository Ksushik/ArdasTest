/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.testforardas;

/**
 *
 * @author ksu
 */
import java.util.HashMap;
import  java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import org.apache.avro.specific.AvroGenerated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Greeting {
    
    final Logger logger;
    private static final int DEFAULT_LOCALE = 0;
    private static final Map <String, Locale> LOCALES_LIST = new HashMap<String, Locale> () {{
	put("en",  new Locale("en", "US"));
	put("ru", new Locale("ru", "UA"));
        }};  
    private ResourceBundle bundle; 
    private static Locale locale; 
    private String message;
    private String baseName;
    private String keyMessage;
    @Autowired
    private DayPartSelector messageType;
 
    @PostConstruct
    public void init() {
        
        this.keyMessage = messageType.getTypeMessage();
    }
    
    public Greeting (){
        this.logger = LoggerFactory.getLogger(Greeting.class);
    }

    public String getMessage() {
        String resultMessage;
        try {
            resultMessage = localizeMessage(keyMessage);
        } catch (MissingResourceException ex1) {
            logger.error("No resource bundle for the specified base name can be found, "
               + "perhaps you should specify the full path to the file: ", ex1);
            throw ex1;
        } catch (NullPointerException ex2) {
            logger.error("baseName is null: ", ex2);
            throw ex2;
        }
        return resultMessage;
    }
 
    
    private String localizeMessage (String keyMessage) {
        this.bundle = getBundle();
        try {
            message = bundle.getString(keyMessage);
        } catch (MissingResourceException ex3) {
            logger.error("No object for the given key can be found, ", ex3);
        } catch (NullPointerException ex4) {
            logger.error("key is null: keyMessage = "+ keyMessage, ex4);
        } catch (ClassCastException ex5) {
            logger.error("The object found for the given key is not a string: keyMessage = " +
               keyMessage + ", message = " + message, ex5);
        }
        logger.info("The metod localizeMessage returned message = " + message);
        return message;
    }

    
    private void getLocale () {
        for (Entry  <String, Locale> i : LOCALES_LIST.entrySet()) { 
            if (i.getKey().equals(Locale.getDefault().getLanguage())) { 
                locale = i.getValue();
                break;
            } else {
                locale = LOCALES_LIST.get("en"); 
                } 
        } logger.debug("The metod localizeMessage initialized the peremeter locale=" + locale);
    }
 
    
    private String getBaseName (Locale locale) {
        if (locale.getLanguage().equalsIgnoreCase("ru")) {
            baseName = "text_ru";
        } else {
            baseName = "text";
        } logger.debug("The metod localizeMessage initialized the peremeter baseName=" + baseName);
        return baseName;
    } 

    
    private ResourceBundle getBundle () {
        getLocale();
        baseName = getBaseName(locale);
        return ResourceBundle.getBundle(baseName, locale);
    }
}
