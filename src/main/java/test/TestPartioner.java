package test;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

import java.util.Map;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/31
 */
public class TestPartioner implements Partitioner {
    @Override
    public int partition(Object o, int numPartitions) {
        System.out.println("i="+numPartitions);
        return 0;
    }

    public TestPartioner(VerifiableProperties verifiableProperties) {

    }

}
