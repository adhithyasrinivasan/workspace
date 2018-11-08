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

public class PublishSubscribe {

	public static void main(String args[]) throws IOException, InterruptedException, TimeoutException, ExecutionException 
	{
		StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster", "foo3");
		Connection natsConn;
		StreamingConnection sc;
		natsConn = Nats.connect("nats://localhost:4222");
		cf.setNatsConnection(natsConn);
		sc = cf.createConnection();
		final CountDownLatch doneSignal = new CountDownLatch(1);
		
		/*Subscription sub = sc.subscribe("foo3", new MessageHandler() {
		    public void onMessage(Message m) {
		        System.out.printf("Received a message: %s\n", new String(m.getData()));
		        doneSignal.countDown();
		    }
		}, new SubscriptionOptions.Builder().deliverAllAvailable().build());
		doneSignal.await();*/
		long startmTime = System.currentTimeMillis();
		for(int i=0;i<1;i++){
			System.out.println("Sending message i "+i);
			String mess="Hello World"+i;
			sc.publish("fook", mess.getBytes());
		}	
		long endmTime   = System.currentTimeMillis();
		System.out.println(startmTime);
		System.out.println(endmTime);
		System.out.println("Total Time in milliseconds: "+(endmTime-startmTime));
		//sub.unsubscribe();
		sc.close();
		natsConn.close();
	}
	
}
