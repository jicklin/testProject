package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/30
 */
public class BooleanTest {

    public static void main(String[] args) {
        Boolean success = null;
        if (Boolean.TRUE.equals(success)) {
            System.out.println(success);

        }

        System.out.println(false && false);
        System.out.println(Runtime.getRuntime().availableProcessors());

        Double s = 8.55556666;
        DecimalFormat decimalFormat = new DecimalFormat("0.000000");
        System.out.println(decimalFormat.format(s));

        BigDecimal bigDecimal = new BigDecimal(s);
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_EVEN).toString());

        Integer a =123;
        long ab = a;
        System.out.println(ab);

    }

    public void parse(Object data) {

    }
}
