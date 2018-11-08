package com.yantra.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import io.nats.client.Options;
import io.nats.client.Options.Builder;
import io.nats.streaming.Message;
import io.nats.streaming.MessageHandler;
import io.nats.streaming.StreamingConnection;
import io.nats.streaming.StreamingConnectionFactory;
import io.nats.streaming.Subscription;
import io.nats.streaming.SubscriptionOptions;

public class RequestReply {

	public static void main(String args[]) throws Exception 
	{
		//StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster", "foo");
		Connection natsConn;
		StreamingConnection sc;
		//Options options = new Options.Builder().server("nats://localhost:2223").server("nats://foo:bar@192.168.1.59:4222").build();
		natsConn = Nats.connect("nats://localhost:4222");
		//cf.setNatsConnection(natsConn);
		//sc = cf.createConnection();
		String subject="subject";
		Dispatcher d = natsConn.createDispatcher((msg) -> {
            System.out.printf("Received message \"%s\" on subject \"%s\", replying to %s\n", 
                                    new String(msg.getData(), StandardCharsets.UTF_8), 
                                    msg.getSubject(), msg.getReplyTo());
            String resp="RSP-"+new String(msg.getData());
            natsConn.publish(msg.getReplyTo(), resp.getBytes());
	    });
		d.subscribe(subject);
		long startmTime = System.currentTimeMillis();
		for(int i=0;i<1;i++){
		//Thread.sleep(200);
		String message="Hello "+i;
		Future<io.nats.client.Message> incoming = natsConn.request(subject, message.getBytes(StandardCharsets.UTF_8));
		io.nats.client.Message msg = incoming.get(5000, TimeUnit.MILLISECONDS);
		//String response = new String(msg.getData(), StandardCharsets.UTF_8);
		System.out.printf("Received reply \"%s\" on subject \"%s\"\n", 
                new String(msg.getData(), StandardCharsets.UTF_8), 
                msg.getSubject());
		}
		long endmTime   = System.currentTimeMillis();
		System.out.println(startmTime);
		System.out.println(endmTime);
		System.out.println("Total Time in milliseconds: "+(endmTime-startmTime));
		
		//sc.close();
		natsConn.flush(Duration.ZERO);
		natsConn.close();
	}
	
}
