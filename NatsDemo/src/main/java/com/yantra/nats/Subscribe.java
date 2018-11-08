package com.yantra.nats;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.streaming.Message;
import io.nats.streaming.MessageHandler;
import io.nats.streaming.StreamingConnection;
import io.nats.streaming.StreamingConnectionFactory;
import io.nats.streaming.Subscription;
import io.nats.streaming.SubscriptionOptions;
	
public class Subscribe {

	public static void main(String args[]) throws Exception
	{
		StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster", "foo5");
		Connection natsConn;
		StreamingConnection sc;
		natsConn = Nats.connect("nats://localhost:4222");
		cf.setNatsConnection(natsConn);
		sc = cf.createConnection();
		final CountDownLatch doneSignal = new CountDownLatch(1);
		// Simple Async Subscriber that retrieves all available messages.
		Subscription sub = sc.subscribe("foo12", new MessageHandler() {
		    public void onMessage(Message m) {
		    	System.out.printf("Received a message: %s\n", new String(m.getData()));
		    	doneSignal.countDown();
		    }
		}, new SubscriptionOptions.Builder().durableName("dardg").build());

		doneSignal.await(5000,TimeUnit.MILLISECONDS);
		//sub.unsubscribe();
		//sub.close();
		sc.close();
		//natsConn.close();
}
}
