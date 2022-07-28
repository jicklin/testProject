package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/2/27
 */
public class LongTest {

    public static void main(String[] args) {
        Long num = null;

        System.out.println(num == null);

        List<Long> ids = new ArrayList<>();
        Long id = 0L;
        while (id < 5) {
            ids.add(0, id);
            id = getAdd(id);

        }

        System.out.println(ids);

        Long lnum = 8L;
        System.out.println(lnum instanceof Number);
    }

    public static Long getAdd(Long id) {
        return id + 1;

    }
}
