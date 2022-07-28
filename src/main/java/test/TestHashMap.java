package test;

import com.suning.framework.commons.utils.MD5Utils;
import org.apache.commons.collections.MapUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/2/20
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("1", 1);
        map.put(null, 10);

        map.remove("2");
        Object absent = map.put("1", 3);
        System.out.println(absent);

        String data = MapUtils.getString(new HashMap(), "data","");
        System.out.println(data.contains("123"));
        System.out.println("["+data+"]");

        System.out.println(map);
        System.out.println(map.get(null));


        String[] strs = new String[]{"venueId","ticketTypeId","ticketTimeId","num","ecardNo","apiKey","timestamp"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        System.out.println(MD5Utils.getMD5("yourSecretKeyapiKey=yourApiKeyecardNo=XXXnum=XXXticketTimeId=XXXticketTypeId=XXX,timestamp=XXXvenueId=XXXyourSecretKey"));



    }
}
