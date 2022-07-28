package test.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import test.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class WorkRec {

	public static final String QUEUE_WORK = "test_queue_work";

	public static void main(String[] args) throws IOException, InterruptedException {
		Connection connection = ConnectionUtil.getConnection();

		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_WORK, false, false, false, null);

		channel.basicQos(1);

		QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

		channel.basicConsume(QUEUE_WORK, false, queueingConsumer);

		while (true) {
			QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println(" [consume 1] Received '" + msg + "'");

			Thread.sleep(10);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}


	}
}
