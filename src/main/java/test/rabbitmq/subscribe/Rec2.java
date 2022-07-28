package test.rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import test.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Rec2 {
	public static final String TEST_EXCHANGE_FANOUT = "test_exchange_fanout";
	public static final String TEST_QUEUE_WORK_2 = "test_queue_work2";

	public static void main(String[] args) throws IOException, InterruptedException {

		Connection connection = ConnectionUtil.getConnection();

		Channel channel = connection.createChannel();

		channel.queueDeclare(TEST_QUEUE_WORK_2, false, false, false, null);

		channel.queueBind(TEST_QUEUE_WORK_2, TEST_EXCHANGE_FANOUT, "");

		channel.basicQos(1);

		QueueingConsumer consumer = new QueueingConsumer(channel);

		channel.basicConsume(TEST_QUEUE_WORK_2, false, consumer);

		while (true) {

			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println("[Rec2] Received '" + message + "'");
			Thread.sleep(10);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

		}




	}

}
