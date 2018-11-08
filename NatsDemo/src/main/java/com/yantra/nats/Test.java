package com.yantra.nats;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
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

public class Test {

	static Connection natsConn;
	static	StreamingConnection sc;
	static StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster", "foo5");
	static Subscription sub;
	public static void main(String[] args) throws Exception {
		callClass();
		sub.unsubscribe();
		sub.close();
		sc.close();
		//natsConn.close();
	}
	
	static void callClass() throws IOException, InterruptedException, TimeoutException
	{
		
		
		natsConn = Nats.connect("nats://localhost:4222");
		cf.setNatsConnection(natsConn);
		sc = cf.createConnection();
		final CountDownLatch doneSignal = new CountDownLatch(1);
		// Simple Async Subscriber that retrieves all available messages.
		sub = sc.subscribe("foo12", new MessageHandler() {
		    public void onMessage(Message m) {
		    	System.out.printf("Received a message: %s\n", new String(m.getData()));
		    	doneSignal.countDown();
		    }
		}, new SubscriptionOptions.Builder().durableName("dardg").build());
		doneSignal.await(10,TimeUnit.SECONDS);
	}
}
