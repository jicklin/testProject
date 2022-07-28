package test;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

import java.util.Random;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/31
 */
public class TestPartioner2 implements Partitioner {
    @Override
    public int partition(Object o, int numPartitions) {
        System.out.println("i="+numPartitions);
        return 1;
    }

    public TestPartioner2(VerifiableProperties verifiableProperties) {

    }

}
