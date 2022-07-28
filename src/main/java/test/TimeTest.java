package test;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/11
 */
public class TimeTest {

    public static void main(String[] args) {
        long targetTime = System.currentTimeMillis();
        long targetTime2 = System.currentTimeMillis()+10;
        System.out.println(targetTime);
        System.out.println(targetTime2);
        System.out.println("********************************************");
        while (System.currentTimeMillis() < targetTime2) {
            System.out.println(System.currentTimeMillis());

        }


    }
}
