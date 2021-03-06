package com.att.archive.restful.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * Data helper utility class
 * */
public class DataUtil {

    //convert class object to json string
    public static String objectToJson(Object object) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(Date.class, new DateSerializer()).create();
        return gson.toJson(object);
    }

    //convert json string to class object
    public static <T> T jsonToObject(String jsonString, Class<T> type) {
         GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(Date.class, new DateDeserializer()).create();
        return gson.fromJson(jsonString, type);
    }

    public static final List fromJsonToList(String json) throws IOException {
        Gson gson = new GsonBuilder().setDateFormat(DateUtil.DATE_FORMAT).create();
        Type typeOfList = new TypeToken<List>() {
        }.getType();
        return gson.fromJson(json, typeOfList);
    }
    //convert String composites to Set collection of Composites
   public  static Set<Map<String, Object>> toCompositeSet(String[] composites){
      if(composites != null){
       Set<Map<String,Object>> compositeSet = new HashSet();
       Map<String,Object> map = new HashMap();
       for(String composite : composites){
          map = DataUtil.jsonToObject(composite, Map.class);
          compositeSet.add(map);
       }
       return compositeSet;
      } 
      return new HashSet();
    }
   
   public static <T> List<T> copyIterator(Iterator<T> iter) {
    List<T> copy = new ArrayList<T>();
    while (iter.hasNext())
        copy.add(iter.next());
    return copy;
   }
}
