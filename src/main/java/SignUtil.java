import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author mal
 * @date 2021-07-21 12:46
 *
 * https://webtest.xports.cn/aisports-api/api/miniApp/exitVenue/queryEntryInfoAndCustInfoByTicket?
 * apiKey=9f1c9242486b564f&timestamp=1626836660330&channelId=11&keyNo=1111&venueId=10000002&netUserId=2019111800000349&centerId=10000000&sign=3d544a658e9de507719fdcc853eff7ae
 */
public class SignUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuilder buf = new StringBuilder();
        buf.append("/aisports-api/api/venue/queryCardValidVenues");
        //Map<String, String> map = Maps.newHashMap();
        //map.put("eCardNo", "E3201000100095840");
        //map.put("staffId","1616");
        //map.put("siteId","50");
        //map.put("apiKey", "9f1c9242486b564f");
        //map.put("token", "123");
        //map.put("timestamp", "1636529042582");
        //Map<String, String> map = Maps.newHashMap();
        //map.put("centerId", "11010002");
        //map.put("custId","2021060300156209");
        //map.put("stuId","2021060300047146");
        //map.put("apiKey", "z4by4bBT694B59a5");
        //map.put("timestamp", "1638867378807");
        //map.put("channelId", "11");
        //map.put("keyNo", "1111");
        //apiKey=9f1c9242486b564f&timestamp=1626844024811&channelId=11&keyNo=1000&venueId=10000002&netUserId=2020111100148559&centerId=10000000&sign=122b59deae9a1f305d91069c83e166ba
       //buf.append("/aisports-api/api/miniApp/exitVenue/settleByKey");
       Map<String, String> map = Maps.newHashMap();
       map.put("venueId", "10000002");
       map.put("netUserId", "2020111100148559");
       map.put("centerId", "10000000");
       map.put("apiKey", "9f1c9242486b564f");
       map.put("timestamp", "1626844024811");
       map.put("channelId", "11");
       map.put("keyNo", "1000");
       buf.append("/aisports-api/api/training/queryTermAndLesson");
       //p<String, String> map = Maps.newHashMap();
       //p.put("courseId", "10003774");
       //p.put("centerId", "10000000");
       //p.put("apiKey", "9f1c9242486b564f");
       //p.put("timestamp", "1626845646279");
       //p.put("channelId", "11");*/
       List<String> list = Lists.newArrayList();
       for (Map.Entry<String, String> entry : map.entrySet()) {
           String key = entry.getKey();
           list.add(key + "=" + entry.getValue());
       }
       String[] params = list.toArray(new String[0]);
       Arrays.sort(params);
       for (String param : params) {
           buf.append(param);
           System.out.println(buf.toString());
       }

       // 连接密钥
       buf.append("MjL95f627Wz523ax");
       String encodeStr = URLEncoder.encode(buf.toString(), "UTF-8").replaceAll("\\+", "%20");
       String md5 = DigestUtils.md5Hex(encodeStr.getBytes(StandardCharsets.UTF_8));

        //
        //Map<String, String> map = Maps.newHashMap();
        //map.put("apiKey", "dd54b124fa1da486");
        //map.put("timestamp","1651053640");
        //map.put("venueId","10000002");
        //map.put("serviceId", "1001");
        //List<String> list = Lists.newArrayList();
        //for (Map.Entry<String, String> entry : map.entrySet()) {
        //    String key = entry.getKey();
        //    list.add(key + "=" + entry.getValue());
        //}
        //String[] params = list.toArray(new String[0]);
        //Arrays.sort(params);
        //StringBuilder sb = new StringBuilder("67b7f0440496c3ac");
        //for (String param : params) {
        //    sb.append(param);
        //    }
        //sb.append("67b7f0440496c3ac");
        //System.out.println(sb.toString());
        ////"67b7f0440496c3acapiKey=dd54b124fa1da486serviceId=1001timestamp=1651053640venueId=1000000267b7f0440496c3ac"
        //
        //System.out.println(DigestUtils.md5Hex(sb.toString()).toUpperCase());


    }
}
