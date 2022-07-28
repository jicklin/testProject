package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suning.aps.toolscommon.util.JsonUtil;
import com.suning.rcse.rsf.dto.response.CrowdPortraitDTO;
import kafka.utils.Json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestFastJson {

	public static void main(String[] args) {
		String json = "{\"aggregations\":{\"age\":{\"5\":2,\"6\":5},\"cust_level_num\":{\"161000000100\":4,\"161000000110\":4,\"161000000120\":1,\"161000000130\":2},\"gender\":{\"F\":1,\"M\":6,\"N\":4},\"purchase_power\":{\"4.0\":1,\"4.1\":1,\"4.3\":1,\"4.5\":1,\"4.6\":1,\"4.7\":1,\"4.9\":1}}";
/*

		JSONObject dataJsonObj = JSONObject.parseObject(json);
		JSONObject crowdPortraitMap = dataJsonObj.getJSONObject("aggregations");

		Map<String, Map<String, Object>> result = new HashMap<>();

		for (String jsonKey : crowdPortraitMap.keySet()) {
			result.put(jsonKey, crowdPortraitMap.getJSONObject(jsonKey));
		}

		System.out.println(result);
*/

		CrowdPortraitDTO portraitDTO = JSON.parseObject(json, CrowdPortraitDTO.class);
		System.out.println(portraitDTO);

		CrowdPortraitDTO crowdPortraitDTO = JsonUtil.readJson2Object(json, CrowdPortraitDTO.class);
		System.out.println(crowdPortraitDTO);

	}
}
