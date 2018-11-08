package com.yantra.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import io.nats.client.Connection;
import io.nats.client.NUID;
import io.nats.client.Nats;
import io.nats.streaming.Message;

public class Subscription {

	public static void main(String[] args) throws IllegalStateException, InterruptedException, IOException {
		Connection nc = Nats.connect("nats://demo.nats.io:4222");

		// Create a unique subject name
		String uniqueReplyTo = "replyto";

		// Listen for a single response
		io.nats.client.Subscription sub = nc.subscribe(uniqueReplyTo);
		sub.unsubscribe(1);

		// Send the request
		nc.publish("time", uniqueReplyTo, "testmessage".getBytes());

		// Read the reply
		io.nats.client.Message msg = sub.nextMessage(Duration.ofSeconds(1));

		// Use the response
		System.out.println(new String(msg.getData(), StandardCharsets.UTF_8));

		// Close the connection
		nc.close();
	}
}
