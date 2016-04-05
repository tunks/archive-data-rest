package com.att.archive.restful.util;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer implements JsonDeserializer<Date> {

      @Override
      public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
          try {
              String date = element.getAsString();        
              return DateUtil.parseDate(date);
          } catch (ParseException ex) {
              Logger.getLogger(DateDeserializer.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
	}
     
}
