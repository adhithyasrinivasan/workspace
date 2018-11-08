package com.yantra.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.streaming.Message;
import io.nats.streaming.MessageHandler;
import io.nats.streaming.StreamingConnection;
import io.nats.streaming.StreamingConnectionFactory;
import io.nats.streaming.Subscription;
import io.nats.streaming.SubscriptionOptions;

public class Publish {

	public static void main(String args[]) throws IOException, InterruptedException, TimeoutException, ExecutionException 
	{
		StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster","foo6");
		Connection natsConn;
		StreamingConnection sc;
		natsConn = Nats.connect("nats://localhost:4222");
		cf.setNatsConnection(natsConn);
		sc = cf.createConnection();
		// Simple Async Subscriber that retrieves all available messages.
		long startmTime = System.currentTimeMillis();
		for(int i=0;i<100;i++){
			String mess="Hell23o W0orld"+i;
			System.out.println(mess);
			sc.publish("foo12", mess.getBytes());
		}	
		long endmTime   = System.currentTimeMillis();
		System.out.println(startmTime);
		System.out.println(endmTime);
		System.out.println("Total Time in milliseconds: "+(endmTime-startmTime));
		sc.close();
		natsConn.close();
	}
	
}
