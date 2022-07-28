package test;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
       /* List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", null);
        mapList.add(map);
        Collection<Object> id = mapList.stream().map(map1 -> map1.get("id")).collect(Collectors.toList());
        System.out.println(id);

        List<String> a = null;
        a.stream().forEach(System.out::println);*/

        IdAndStrDto a1 = new IdAndStrDto("a", 12);
        IdAndStrDto b1 = new IdAndStrDto("b", 123);

        List<IdAndStrDto> list = Lists.newArrayList(a1, b1);
        Map<Integer,String> collect = list.stream().collect(Collectors.toMap(IdAndStrDto::getId, IdAndStrDto::getName));
        System.out.println(collect);

        System.out.println((long) (5 - (5 * 0.9)));

        List<IdAndStrDto> objects = new ArrayList<>();
        int sum = objects.stream().mapToInt(IdAndStrDto::getId).sum();
        System.out.println("sum:" + sum);


    }

}
