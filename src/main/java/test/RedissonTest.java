package test;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/7/2
 */
public class RedissonTest {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSentinelServers().addSentinelAddress("redis://10.27.18.225:26379");

        RedissonClient redisson = Redisson.create(config);

        RLock lock = redisson.getLock("myLock");

        lock.lock();

    }
}
