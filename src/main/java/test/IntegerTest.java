package test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import scala.Int;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/7
 */
public class IntegerTest {

    public static void main(String[] args) {
        /*Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);

        Long c = 127L;
        Long d = 127L;
        System.out.println(c == d);

        System.out.println(Integer.MAX_VALUE);

        Integer count = 0;
        System.out.println(count instanceof Number);
        Integer count1 = 0;
        changeValue(++count1);
        System.out.println(count1);

        Integer a1 = null;
        System.out.println(a1 != 0);*/

        JSONObject jsonObject = JSONObject.parseObject("{\"id\":9999991793}");
        System.out.println(jsonObject);

        List<Integer> data = Lists.newArrayList(5, 4, 3, 2, 1);
        List<Integer> collect = data.stream().filter(i -> i > 3).collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }


    }

    private static void changeValue(int count1) {
        System.out.println("方法内部的:"+count1);
    }
}
