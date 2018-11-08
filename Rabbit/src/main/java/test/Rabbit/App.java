package test.Rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void publish(int i) throws Exception
    {
		ConnectionFactory factory = new ConnectionFactory();
    	factory.setHost("172.17.0.3");
    	factory.setUsername("guest");
    	factory.setPassword("guest");
    	com.rabbitmq.client.Connection connection = factory.newConnection();
    	Channel channel = connection.createChannel();
    	String message = "{\"test\":\"hello "+i+" world\"}";
    	channel.basicPublish("", "testQueue", null, message.getBytes());
    	channel.close();
    	connection.close();
    }
}
