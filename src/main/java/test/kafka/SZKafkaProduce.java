package test.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class SZKafkaProduce {

	private static String brokers = "kafkaprexg01broker01.cnsuning.com:9092,kafkaprexg01broker02.cnsuning.com:9092,kafkaprexg01broker03.cnsuning.com:9092";

	private static final String ACKS = "1";

	private static final String PRODUCERTYPE = "sync";

	private static final String TOPIC = "sync_mems_to_aps";

	private static final String message = "{\"appCode\":\"wbank\",\"groupCode\":\"DS1001\",\"groupName\":\"0601数智一次性1\",\"groupDesc\":\"0601数智一次性1\",\"customid\":\"7013473102\",\"hiveTable\":\"0601sunlongNB\",\"statisDate\":\"20191031\",\"sql\":\"(num_sum_720_lm02943 >='1' and num_sum_720_lm02943 <='13')\",\"syncType\":\"0\",\"crowdType\":\"2\",\"deviceType\":\"1\",\"encryptionType\":\"0\",\"ifYzt\":\"0\"}";

	public static void main(String[] args) {

		Properties prop = new Properties();

		prop.put("metadata.broker.list", brokers);

		prop.put("request.required.acks", ACKS);

		prop.put("producer.type", PRODUCERTYPE);

		ProducerConfig config = new ProducerConfig(prop);

		Producer producer = new Producer(config);

		try {

			KeyedMessage<byte[], byte[]> data = new KeyedMessage<byte[], byte[]>(TOPIC, message.getBytes("UTF-8"));

			for (int i = 0; i < 1; i++) {

				System.out.println(i);

				producer.send(data);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
