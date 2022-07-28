package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/27
 */
public class InstanceTest {

    public static void main(String[] args) {
        Long userId = 0L;
        System.out.println((userId instanceof Long));

        List list = new ArrayList();

        Class clazz = list.getClass();
        System.out.println(List.class.isAssignableFrom(clazz));

    }
}
