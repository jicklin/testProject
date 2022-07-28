package test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mal
 * @date 2021-08-18 8:42
 */
public class TestCopy {

    public static void main(String[] args) {
        TestXml.Student student = new TestXml.Student();
        student.setName("小白");
        ArrayList<TestXml.Student> students = Lists.newArrayList(student);
        List<TestXml.Student> dest = students.stream().collect(Collectors.toList());
        student.setName("小黑");
        System.out.println(dest);


    }
}
