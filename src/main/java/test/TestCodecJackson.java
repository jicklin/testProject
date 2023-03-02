package test;

import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

/**
 * @author mal
 * @date 2022-09-15 11:44
 */
public class TestCodecJackson {

    private static ObjectMapper mapper = new ObjectMapper();



    public static void main(String[] args) {
        String jsonStr2 = "{\"auditId\":2022091100221802,\"manualReduction\":\"180.00\",\"venueId\":3302000101,\"orderDiscount\":0,\"auditRemark\":\"支付减免 180.00 元\n减免备注：申请馆长（9折）\",\"tradeDesc\":\"老用户办专项卡\",\"custName\":\"13454729196\",\"tradeId\":2022091115044398,\"staffId\":5913,\"tradeTypeCode\":10,\"productName\":\"游泳50次年卡\",\"auditTaskInfo\":{\"tradeTypeName\":\"办卡\",\"applyName\":\"水梦琪\",\"venueId\":3302000101,\"venueName\":\"游泳馆\",\"applyDate\":\"2022-09-11 20:03:02\",\"fee\":\"1800.0\",\"remark\":\"\",\"eCardNo\":\"E3302000100024470\",\"auditPageData\":{}}}";
        try {
            JSONObject jsonObject = JSONObject.fromObject(jsonStr2);
            System.out.println(jsonObject);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
