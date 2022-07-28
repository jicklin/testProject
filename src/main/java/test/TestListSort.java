package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mal
 * @date 2021-11-29 10:33
 */
public class TestListSort {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();

        list.add(1101000229L);
        list.add(1101000233L);
        list.add(1101000234L);
        list.add(1101000235L);
        list.add(1101000237L);
        list.add(1101000249L);
        list.add(1101000250L);
        list.add(1101000251L);
        list.add(1101000252L);

        Long finalManageVenueId = 1101000235L;


        System.out.println(list);
        list.sort((a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            if (a.equals(finalManageVenueId)) {
                return -1;
            }
            if (b.equals(finalManageVenueId)) {
                return 1;
            }
            return a.compareTo(b);

        });
        System.out.println(list);
    }
}
