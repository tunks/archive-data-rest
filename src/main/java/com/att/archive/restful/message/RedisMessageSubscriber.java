
package com.att.archive.restful.message;

/**
 *
 * @author ebrima
 */
import java.util.Arrays;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
 
public class RedisMessageSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message Received on channel " + Arrays.toString(message.getChannel()) + " message :: " + message.toString() );
    }
}
