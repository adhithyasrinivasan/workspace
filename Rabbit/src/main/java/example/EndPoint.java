package example;

import java.io.IOException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class EndPoint{
	
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;
	
    public EndPoint(String endpointName) throws Exception, Exception{
         this.endPointName = endpointName;
		 ConnectionFactory factory = new ConnectionFactory();
	     factory.setHost("172.17.0.3");
		 connection = factory.newConnection();
	     channel = connection.createChannel();
	     channel.queueDeclare(endpointName, true, false, false, null);
    }
	/**
     * Close channel and connection. Not necessary as it happens implicitly any way. 
     * @throws IOException
     */
     public void close() throws Exception{
         this.channel.close();
         this.connection.close();
     }
}