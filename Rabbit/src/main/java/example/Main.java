package example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {
	@SuppressWarnings("deprecation")
	public Main() throws Exception{
		
		QueueConsumer consumer = new QueueConsumer("testQueue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		
		Producer producer = new Producer("testQueue");
		/*for (int i = 0; i < 100000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number "+ i +" sent.");
		}*/
		producer.sendMessage("{\"test\":\"TEST\"}");
		consumerThread.stop();
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception{
	  new Main();
	}
}