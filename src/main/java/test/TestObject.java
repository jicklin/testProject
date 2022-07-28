package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mal
 * @date 2021-08-04 15:40
 */
public class TestObject {

    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        System.out.println(((TestXml.Student) data.get("123")));
    }
}
