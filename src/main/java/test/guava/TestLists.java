package test.guava;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class TestLists {
	public static void main(String[] args) {
		Student student = new Student("馬琳");
		List<Student> studentList = new ArrayList<>();
		studentList.add(student);
		System.out.println("之前" + studentList);
		ArrayList<Student> copyList = Lists.newArrayList(studentList);
		System.out.println(copyList);
		student.setName("马林222");
		System.out.println("之后" + studentList);
		System.out.println("之后2" + copyList);

		List<List<Student>> partition = Lists.partition(studentList, 2);
		System.out.println(partition);
	}
}
