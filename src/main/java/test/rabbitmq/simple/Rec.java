package test.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import test.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Rec {

	public static final String QUEUE_NAME = "q_test_01";

	public static void main(String[] args) throws IOException, InterruptedException {
		// 获取连接及mq通道
		Connection connection = ConnectionUtil.getConnection();

		// 从连接中创建通道
		Channel channel = connection.createChannel();

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 定义队列的消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);

		// 监听队列
		channel.basicConsume(QUEUE_NAME, true, consumer);

		// 获取消息
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
		}

	}
}
