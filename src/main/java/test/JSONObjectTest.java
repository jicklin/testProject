package test;


import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSONObjectTest {
	static ObjectMapper objectMapper = new ObjectMapper();


	public static void main(String[] args) {
		/*JSONObject object = JSONObject.parseObject("{\"submit_amnt\":\"0\",\"cost\":\"48381\",\"submit_num\":\"0\",\"clct_num\":\"0\",\"pv\":\"4095\",\"deal_amnt\":\"13\",\"shopcart_num\":\"0\",\"deal_num\":\"3217290\",\"click\":\"451\",\"process_time\":\"2020-04-30 13:56:00\"}");
		System.out.println(object);

		System.out.println(object.toString());*/
		JSONObject object = JSONObject.fromObject("{\"submit_amnt\":null,\"cost\":\"48381\"}");
		System.out.println(object);
		try {
			String s = objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
