package com.att.archive.restful.message;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author ebrima

**/
public interface MessageDelegate {
  void handleMessage(String message);
  void handleMessage(Map message); void handleMessage(byte[] message);
  void handleMessage(Serializable message);
  // pass the channel/pattern as well
  void handleMessage(Serializable message, String channel);
 }

