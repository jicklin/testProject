package test.synchronization;

/**
 * @author mal
 * @date 2021-08-20 16:08
 */
public class SellTickets {
    public static void main(String[] args) {
        TicketSeller2 seller = new TicketSeller2();
        TicketSeller2 seller2 = new TicketSeller2();

        Thread t1 = new Thread(seller, "窗口1");
        Thread t2 = new Thread(seller2, "窗口2");
        //Thread t3 = new Thread(seller, "窗口3");

        t1.start();
        t2.start();
        //t3.start();
    }
}

class TicketSeller extends Thread {
    private static int tickets = 20;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
            }
        }
    }
}

class TicketSeller2 implements Runnable {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }

    public synchronized static void sellTicket() {
        try {
            Thread.sleep(10);
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

