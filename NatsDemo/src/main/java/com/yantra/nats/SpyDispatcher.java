package com.yantra.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import io.nats.streaming.Message;
import io.nats.streaming.MessageHandler;
import io.nats.streaming.StreamingConnection;
import io.nats.streaming.StreamingConnectionFactory;
import io.nats.streaming.Subscription;
import io.nats.streaming.SubscriptionOptions;

public class SpyDispatcher 
{
	public static void	main(String args[]) throws IOException, InterruptedException, TimeoutException
	{
		StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster", "spy");
		Connection natsConn;
		StreamingConnection sc;
		natsConn = Nats.connect("nats://user1:pass1@localhost:4222");
		cf.setNatsConnection(natsConn);
		sc = cf.createConnection();
		String subject="subject";
		Dispatcher d = natsConn.createDispatcher((msg) -> {
			System.out.println(msg.getReplyTo());
            System.out.printf("Received message \"%s\" on subject \"%s\", replying to %s\n", 
                                    new String(msg.getData(), StandardCharsets.UTF_8), 
                                    msg.getSubject(),msg.getReplyTo());
           
        });
		d.subscribe("foo4");
		d.subscribe("*.>");
}
	
		
	
}
