package test.lock;

/**
 * @author mal
 * @date 2022-07-28 14:47
 */
public class TestSynchronized {

    public static void main(String[] args) {
        testStringLock();


    }


    public static String getKey(String keyId) {
        synchronized (keyId.intern()) {
            System.out.println(Thread.currentThread().getName() + "获取锁");
            //try {
            //    TimeUnit.SECONDS.sleep(1);
            //} catch (InterruptedException e) {
            //    throw new RuntimeException(e);
            //}
            System.out.println(Thread.currentThread().getName() + "执行结束");

        }
        return null;

    }


    public static void testStringLock() {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                getKey(new String("1"));

            }).start();
        }
    }
}
