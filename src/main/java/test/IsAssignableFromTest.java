package test;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/24
 */
public class IsAssignableFromTest {

    public static void main(String[] args) {
        String str = null;
        System.out.println(Object.class.isAssignableFrom(str.getClass()));

    }
}
