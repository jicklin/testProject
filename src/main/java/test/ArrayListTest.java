package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/13
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("123");
            add("456");
        }};

        List<String> list1 = new ArrayList<String>() {{
            add("789");
            add("123");
        }};

        list.addAll(list1);


        System.out.println(list);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "小王");
        map.put("age", 123);
        System.out.println(map);
    }
}
