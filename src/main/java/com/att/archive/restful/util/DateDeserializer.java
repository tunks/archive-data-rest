package com.att.archive.restful.util;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer implements JsonDeserializer<Date> {
      public static String DateFormat = "yyyy-MM-dd'T'HH:mm:ssX"; //"MM-dd-yyyy";
      @Override
      public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
          try {
              String date = element.getAsString();
           
              return DateDeserializer.deserialize(date);
          } catch (ParseException ex) {
              Logger.getLogger(DateDeserializer.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
	}
      
      //static deserialize method
      public static Date deserialize(String date) throws ParseException{
            TimeZone tz = TimeZone.getTimeZone("UTC");
            SimpleDateFormat formatter = new SimpleDateFormat(DateDeserializer.DateFormat);
            formatter.setTimeZone(tz);
            //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter.parse(date);
      }
}
