package com.att.archive.restful.util;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateSerializer implements JsonSerializer<Date> {  
        public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
          return new JsonPrimitive(sdf.format(date));
        }
}  
