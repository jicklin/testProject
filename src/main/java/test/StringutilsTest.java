package test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/7
 */
public class StringutilsTest {

    public static void main(String[] args) {

        String str = "1,,";

        System.out.println(StringUtils.split(str, ",").length);
        System.out.println(Arrays.toString(StringUtils.split(str, ",")));

        boolean b = Arrays.stream(StringUtils.split(str, ",")).allMatch(str1 -> str1.length() > 2);
        System.out.println(b);

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        appendQuotation(list);

        System.out.println(list);




    }
    private static void appendQuotation(List<String> strList) {
        if (strList.isEmpty()) {
            return;
        }
        for (int i = 0; i < strList.size(); i++) {
            strList.set(i, "'" + strList.get(i) + "'");
        }
    }
}
