package test;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/20
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal num = new BigDecimal("100");
        System.out.println(System.identityHashCode(num));
        System.out.println(num.hashCode());
        BigDecimal a1 = num;
        System.out.println(System.identityHashCode(a1));

        a1 = a1.add(new BigDecimal("2"));
        System.out.println(System.identityHashCode(a1));

        //System.out.println(a1);
        //System.out.println(num);

        BigDecimal divide = new BigDecimal("10").divide(new BigDecimal("3"), 4, RoundingMode.HALF_UP);
        //System.out.println(divide.doubleValue());
        //System.out.println(divide.longValue());
    }
}
