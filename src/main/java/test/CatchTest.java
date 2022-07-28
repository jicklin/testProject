package test;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/4/9
 */
public class CatchTest {

    public static void main(String[] args) {
        String Str = "1";
        try {

            Str = getHHH();
        } catch (Exception e) {

        }
        System.out.println(Str);

    }

    private static String getHHH()  {
        throw new RuntimeException("123");
    }
}
