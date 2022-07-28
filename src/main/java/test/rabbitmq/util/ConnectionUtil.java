package test.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class ConnectionUtil {

	public static Connection getConnection() throws IOException {
		// 定义个连接工厂
		ConnectionFactory connectionFactory = new ConnectionFactory();

		// 设置服务地址
		connectionFactory.setHost("localhost");

		// 设置服务端口
		connectionFactory.setPort(5672);

		// 设置vhost 用户名 密码
		connectionFactory.setVirtualHost("testhost");
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("123");

		// 获取连接
		return connectionFactory.newConnection();
	}
}
