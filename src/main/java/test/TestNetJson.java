package test;

import net.sf.json.JSONObject;

public class TestNetJson {

    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        System.out.println(object.get("123"));

        String s = "1230";
        System.out.println(s.substring(0, 3));

        Long money = 1000L;
        System.out.println(money/100.0);
    }
}
