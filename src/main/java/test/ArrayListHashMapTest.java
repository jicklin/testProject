package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/5
 */
public class ArrayListHashMapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", "malin");

        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(map);

        System.out.println(mapList);

        Map<String, Object> objectMap = mapList.get(0);
        objectMap.put("name", "jiajia");
        System.out.println(mapList);
    }
}
