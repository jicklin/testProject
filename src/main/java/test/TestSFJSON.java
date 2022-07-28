package test;

import net.sf.json.JSONObject;

/**
 * @author mal
 * @date 2021-11-25 10:50
 */
public class TestSFJSON {

    public static void main(String[] args) {
        JSONObject object = JSONObject.fromObject("{\"rentCnt\": 0,\"\"}");
        System.out.println(object.getInt("rentCnt"));
    }
}
