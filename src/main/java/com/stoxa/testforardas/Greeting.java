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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import  java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Greeting {
    
final Logger logger = LoggerFactory.getLogger(Greeting.class);

    
 private static final int DEFAULT_LOCALE = 0;
 private static final Locale[] supportedLocales = {new Locale("en", "US"), new Locale("ru", "UA") }; 
 private static final List <Locale> localesList = new ArrayList<Locale> (Arrays.asList(supportedLocales));
 private ResourceBundle bundle; 
 public static Locale locale; 
 String message;
 String baseName;
 
 
 public String  localizeMessage (String keyMessage) { 
     getLocale();
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
       logger.error("No object for the given key can be found, ", ex3);
    } catch (NullPointerException ex4) {
       logger.error("key is null: keyMessage = "+ keyMessage, ex4);
    }  catch (ClassCastException ex5) {
       logger.error("The object found for the given key is not a string: keyMessage = " +
               keyMessage + ", message = " + message + ex5.getStackTrace(), ex5);
   }
   logger.info("The metod localizeMessage returned message = " + message);
return message;
}
 private void getLocale () {
     
         for (Locale i : localesList) { 
         if (i.getLanguage().equals(Locale.getDefault().getLanguage())) { 
             locale = i;
             break;
         }  else {
             locale = supportedLocales[DEFAULT_LOCALE]; 
             } 
     } logger.debug("The metod localizeMessage initialized the peremeter locale=" + locale);
     }
  private String getBaseName (Locale locale) {
     if (locale.getLanguage().equalsIgnoreCase("ru")) {
         baseName = "text_ru";
     }
     else {
         baseName = "text";
     }
     logger.debug("The metod localizeMessage initialized the peremeter baseName=" + baseName);
     return baseName;
     }
  
  
}
