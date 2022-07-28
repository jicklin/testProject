package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mal
 * @date 2022-03-17 14:42
 */
public class TestRefernce {

    public static void main(String[] args) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();

        TestXml.Student a = new TestXml.Student(){{setName("小黑");}};
        stringObjectHashMap.put("hah", a);
        a =  new TestXml.Student(){{setName("小红");}};
        System.out.println(stringObjectHashMap);
        a.setName("小白");

        System.out.println(stringObjectHashMap);

        List<TestXml.Student> list = new ArrayList<>();
        list.add(new TestXml.Student() {{
            setName("小黑");
        }});
        list.add(new TestXml.Student() {{
            setName("小白");
        }});

        List<TestXml.Student> collect = list.stream().filter(stu -> "小白".equals(stu.getName())).collect(Collectors.toList());
        collect.get(0).setAge(1);
        System.out.println(list);
        System.out.println(collect);

        System.out.println();


    }
}
