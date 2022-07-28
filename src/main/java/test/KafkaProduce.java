package test;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/2/20
 */
public class KafkaProduce {


    private static String brokers = "kafkasit02broker01.cnsuning.com:9092,kafkasit02broker02.cnsuning.com:9092,kafkasit02broker03.cnsuning.com:9092";

    private static final String ACKS = "1";

    private static final String PRODUCERTYPE = "sync";

    private static final String TOPIC = "ldps_task_flg";

    private static final String message = "{\"statis_date\":\"20200528\",\"product_line\":\"DSP\",\"brand_cd\":\"000010254\",\"level\":\"高\",\"crowd_id\":\"000010254DSP\",\"send_cnt\":1200,\"table\":\"ldps.brand_advertising_mem_d\"}";

    public void sendMessage(String partionerClass) {
        Properties prop = new Properties();
        prop.put("metadata.broker.list", brokers);
        prop.put("request.required.acks", ACKS);
        prop.put("producer.type", PRODUCERTYPE);
//        prop.put("partitioner.class",partionerClass);
        ProducerConfig config = new ProducerConfig(prop);
        Producer producer = new Producer(config);
        try {
            KeyedMessage<byte[], byte[]> data = new KeyedMessage<byte[], byte[]>(TOPIC, message.getBytes("UTF-8"), message.getBytes("UTF-8"));
            for (int i = 0; i < 2; i++) {

                System.out.println(i);

                producer.send(data);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        KafkaProduce produce = new KafkaProduce();
        produce.sendMessage("test.TestPartioner");
       /* produce.sendMessage("test.TestPartioner2");*/

    }
}
