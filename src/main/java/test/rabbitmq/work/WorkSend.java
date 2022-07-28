package test.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import test.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class WorkSend {
	public static final String QUEUE_WORK = "test_queue_work";



	public static void main(String[] args) throws IOException, InterruptedException {

		Connection connection = ConnectionUtil.getConnection();

		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_WORK, false, false, false, null);

		for (int i = 0; i < 100; i++) {
			String message = "" + i;
			channel.basicPublish("", QUEUE_WORK, null, message.getBytes());
			System.out.println(" [ producer] Sent '" + message + "'");
			Thread.sleep(i * 10);

		}


	}
}
