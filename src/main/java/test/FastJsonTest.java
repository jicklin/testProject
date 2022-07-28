package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/27
 */
public class FastJsonTest {

    public static void main(String[] args) {


        String msg = "[]";
        JSONArray array = JSON.parseArray(msg);
        System.out.println(array.toJSONString());



    }
}
