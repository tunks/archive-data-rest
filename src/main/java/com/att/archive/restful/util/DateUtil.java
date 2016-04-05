/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author ebrimatunkara
 */
public class DateUtil {
       final public static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX"; //"MM-dd-yyyy";
      final public static String[] DATE_REGEX = {"^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$",
                                                 "^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}T[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}+Z?$"
                    };
      //static parseDate method
      public static Date parseDate(String date) throws ParseException{
            TimeZone tz = TimeZone.getTimeZone("UTC");
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
            formatter.setTimeZone(tz);
            //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter.parse(date);
      }
      
      /**
       * Validate date string
       * @param dateString
       * @return 
       **/
      public  static boolean isValidateDate(String dateString){
         for (String regex : DATE_REGEX) {        
               if(  dateString.matches(regex)){
                  return true;
              }
         }
        return false;
      }
}
