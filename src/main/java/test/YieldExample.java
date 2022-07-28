package test;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/13
 */
public class YieldExample {

    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread customer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY);
        customer.setPriority(Thread.MAX_PRIORITY);
        producer.start();
        customer.start();

    }




}

class Producer extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(" producer Item " + i);
            yield();
        }
    }
}


class Consumer extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(" customer Item " + i);
            yield();
        }
    }
}
