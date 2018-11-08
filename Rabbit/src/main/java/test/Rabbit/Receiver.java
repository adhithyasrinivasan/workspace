package test.Rabbit;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class Receiver 
{
	static ObjectMapper mapper = new ObjectMapper();
	private static final String TASK_QUEUE_NAME = "testQueue";
	public static void main(String[] argv) throws Exception 
	{
		for(int i=1;i<=1;i++)
		{
			publish(i);
			get();
		}
	}
	public static void get() throws Exception
	{
		ConnectionFactory factory = new ConnectionFactory();
    	factory.setHost("localhost");
    	factory.setUsername("guest");
    	factory.setPassword("guest");
    	//factory.setVirtualHost("");
    	com.rabbitmq.client.Connection connection = factory.newConnection();
    	Channel channel = connection.createChannel();
    	//channel.queuePurge("testQueue");
    	boolean deci=true;
    	while(deci)
    	{
    		boolean autoAck = false;
           	GetResponse response = channel.basicGet(TASK_QUEUE_NAME, autoAck);
        	if (response == null) 
        	{
        	    // No message retrieved.
        	} 
        	else 
        	{
        	    AMQP.BasicProperties props = response.getProps();
        	    byte[] body = response.getBody();
        	    long deliveryTag = response.getEnvelope().getDeliveryTag();
        	    channel.basicAck(deliveryTag, false);
        	    System.out.println(new String(response.getBody(),"UTF-8"));
        	}
    	}
    	channel.close();
    	connection.close();
	}
	
	public static void publish(int i) throws Exception
    {
		ConnectionFactory factory = new ConnectionFactory();
    	factory.setHost("localhost");
    	factory.setUsername("guest");
    	factory.setPassword("guest");
    	//factory.setVirtualHost("");
    	com.rabbitmq.client.Connection connection = factory.newConnection();
    	Channel channel = connection.createChannel();
    	//channel.queuePurge("testQueue");
		String message = "{\"test\":\"hello "+i+" world\"}";
    	channel.basicPublish("", TASK_QUEUE_NAME, null, message.getBytes());
    	channel.close();
    	connection.close();
    	
    }
	public static void testConsume(int i) throws Exception
	{
		ConnectionFactory factory = new ConnectionFactory();
    	factory.setHost("localhost");
    	factory.setUsername("guest");
    	factory.setPassword("guest");
    	final com.rabbitmq.client.Connection connection = factory.newConnection();
    	final Channel channel = connection.createChannel();
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		final boolean set=true;
	    final Consumer consumer = new DefaultConsumer(channel) 
	    {
	    	@Override
	    	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException 
	    	{
	    		String message = new String(body, "UTF-8");
	    		System.out.println(" [x] Received '" + message + "'");
	    		try 
	    		{
	    			if(set)
	    			//doWork(message);
	    				doM(message);
	    		} 
	    		finally 
	    		{
	    			System.out.println(" [x] Done");
	    			channel.basicAck(envelope.getDeliveryTag(), false);
	    			try 
	    			{
	    				channel.close();
	    				connection.close();
	    			} 
	    			catch (Exception e) 
	    			{
	    				e.printStackTrace();
	    			}
	    		}
	    	}
	    };
	    boolean autoAck = false;
	    channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
	}
	
	
	private static void doWork(String task) 
	{
		for (char ch : task.toCharArray()) 
	    {
	    	if (ch == '.') 
	    	{
	    		try 
	    		{
	    			Thread.sleep(1000);
	    		}
	    		catch (InterruptedException _ignored) 
	    		{
	    			Thread.currentThread().interrupt();
	    		}
	    	}
	    }
	}
	private static void doM(String testn) throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("Entering into "+testn);
		ObjectMapper mapper = new ObjectMapper();
		TestString testa = mapper.readValue(testn, TestString.class);
		System.out.println("exited to "+testa.getTest());		
		
	}
}
class TestString
{
	static String test;

	@Override
	public String toString() {
		return "TestString []";
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}

