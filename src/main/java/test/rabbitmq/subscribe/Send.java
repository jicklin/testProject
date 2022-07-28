package test.rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import test.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Send {

	public static final String TEST_EXCHANGE_FANOUT = "test_exchange_fanout";

	public static void main(String[] args) throws IOException {
		Connection connection = ConnectionUtil.getConnection();

		Channel channel = connection.createChannel();

		channel.exchangeDeclare(TEST_EXCHANGE_FANOUT, "fanout");

		String message = "hello exchange";

		channel.basicPublish(TEST_EXCHANGE_FANOUT,"",null,message.getBytes());

		System.out.println(" [x] sent '" + message + "'");

		channel.close();
		connection.close();

	}
}
