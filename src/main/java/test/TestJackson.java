package test;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestJackson {
	static ObjectMapper objectMapper = new ObjectMapper();
	static {
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


	}


	public static void main(String[] args) throws JsonProcessingException {

		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		/*String jsonStr = "{\"name\":\"lin\",\"address\":\"新沂\"}";
		try {
			TestXml.Student student = objectMapper.readValue(jsonStr, TestXml.Student.class);
			System.out.println(student);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/
/*
		String jsonStr = "{\"occupyId\":123,\"conflictTradeIds\":[123,456,789],\"createTime\":\"2022-09-01 14:59:00\"}";
		try {
			BatchHandleInfo batchHandleInfo = objectMapper.readValue(jsonStr, new TypeReference<BatchHandleInfo>() {
			});
			System.out.println(batchHandleInfo);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/

		String jsonStr2 = "{\"auditId\":2022091100221802,\"manualReduction\":\"180.00\",\"venueId\":3302000101,\"orderDiscount\":0,\"auditRemark\":\"支付减免 180.00 元\\n减免备注：申请馆长（9折）\",\"tradeDesc\":\"老用户办专项卡\",\"custName\":\"13454729196\",\"tradeId\":2022091115044398,\"staffId\":5913,\"tradeTypeCode\":10,\"productName\":\"游泳50次年卡\",\"auditTaskInfo\":{\"tradeTypeName\":\"办卡\",\"applyName\":\"水梦琪\",\"venueId\":3302000101,\"venueName\":\"游泳馆\",\"applyDate\":\"2022-09-11 20:03:02\",\"fee\":\"1800.0\",\"remark\":\"\",\"eCardNo\":\"E3302000100024470\",\"auditPageData\":{}}}";
		try {
			//Map map = objectMapper.readValue(jsonStr2, Map.class);
			//System.out.println(objectMapper.writeValueAsString(map));
			JSONObject jsonObject = JSONObject.fromObject(jsonStr2);
			System.out.println(jsonObject);
			System.out.println(jsonObject.get("auditRemark"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//try {
		//	Map<String,Object> map = objectMapper.readValue(jsonStr, Map.class);
		//	map = new HashMap<>();
		//	System.out.println(map);
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		//
		//Object transform = new TestJackson().transform("{\"connectStr\":\"~\",\"min\":0,\"rightStr\":\"天（0~30）\",\"max\":30,\"leftStr\":\"用户到今日连续到访\",\"sqlTemp\":\"lianxu>'%s' and lianxu <'%s'\"}",DateRangeDto.class);
		//
		//System.out.println(transform);
		//System.out.println(transform.getClass());
		//TestXml.Student student = new TestXml.Student();
		//student.setName("malin");
		//Long[] ids = new Long[]{4L, 5L, 6L};
		//Object[] arr = new Object[]{"abc", 123, student, ids, null};
		//ArrayList<Object> objects = new ArrayList<>();
		////objects.add("abc");
		////objects.add(123);
		////objects.add(null);
		////objects.add(student);
		//String s = objectMapper.writeValueAsString(objects);
		//System.out.println(s);
	}

	public <T> T transform(String id,Class<T> tClass) {
		try {
			return objectMapper.readValue(id, tClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static class BatchHandleInfo implements Serializable {
		private static final long serialVersionUID = -322270457413769469L;
		private Long occupyId;

		private List<Long> conflictTradeIds;

		private Date createTime;

		public BatchHandleInfo() {
		}

		public BatchHandleInfo(Long occupyId, List<Long> conflictTradeIds) {
			this.occupyId = occupyId;
			this.conflictTradeIds = conflictTradeIds;
			this.createTime = new Date();
		}

		public Long getOccupyId() {
			return occupyId;
		}

		public void setOccupyId(Long occupyId) {
			this.occupyId = occupyId;
		}

		public List<Long> getConflictTradeIds() {
			return conflictTradeIds;
		}

		public void setConflictTradeIds(List<Long> conflictTradeIds) {
			this.conflictTradeIds = conflictTradeIds;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
	}

}
