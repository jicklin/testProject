package test;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/7
 */
public class StringTest {

    public static void main(String[] args) {

        String str = "!!!!!!!";
        System.out.println(str.replace("!","@"));

        Map<String, Object> map = new HashMap<>();
        int value = 123;
        map.put("123", value);

        System.out.println(map.get("123") instanceof Number);

        StringBuilder sb = new StringBuilder();
        sb.append("123");

        sb.insert(0, "(").append(")");
        System.out.println(sb);


        try {
            System.out.println("123123");

        } catch (Exception e) {

        }finally {
            System.out.println("final");
        }

        System.out.println("end");


        System.out.println(StringUtils.isNumeric("  "));

        System.out.println("''".replaceAll("'","''"));

        String a = null;
        System.out.println("123123-"+a);




    }
}
