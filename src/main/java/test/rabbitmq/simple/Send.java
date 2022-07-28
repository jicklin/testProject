package test.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import test.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Send {

	public static final String QUEUE_NAME = "q_test_01";

	public static void main(String[] args) throws IOException {
		// 获取连接及mq通道
		Connection connection = ConnectionUtil.getConnection();

		// 创建mq通道
		Channel channel = connection.createChannel();

		// 声明创建一个队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);


		// 发送信息
		String msg = "Hello RabbitMQ";
		channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		System.out.println(" [X] Send '" + msg + "'");
		// 关闭通道和；连接
		channel.close();

		connection.close();


	}


}
