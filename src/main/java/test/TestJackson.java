package test;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestJackson {
	static ObjectMapper objectMapper = new ObjectMapper();
	static {
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

	}


	public static void main(String[] args) throws JsonProcessingException {

		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

		String jsonStr = "{\"name\":\"lin\"}";

		try {
			Map<String,Object> map = objectMapper.readValue(jsonStr, Map.class);
			map = new HashMap<>();
			System.out.println(map);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object transform = new TestJackson().transform("{\"connectStr\":\"~\",\"min\":0,\"rightStr\":\"天（0~30）\",\"max\":30,\"leftStr\":\"用户到今日连续到访\",\"sqlTemp\":\"lianxu>'%s' and lianxu <'%s'\"}",DateRangeDto.class);

		System.out.println(transform);
		System.out.println(transform.getClass());
		TestXml.Student student = new TestXml.Student();
		student.setName("malin");
		Long[] ids = new Long[]{4L, 5L, 6L};
		Object[] arr = new Object[]{"abc", 123, student, ids, null};
		ArrayList<Object> objects = new ArrayList<>();
		//objects.add("abc");
		//objects.add(123);
		//objects.add(null);
		//objects.add(student);
		String s = objectMapper.writeValueAsString(objects);
		System.out.println(s);
	}

	public <T> T transform(String id,Class<T> tClass) {
		try {
			return objectMapper.readValue(id, tClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
