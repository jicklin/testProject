package test;

import com.suning.rsf.util.MD5Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsSorts {

	public static void main(String[] args) {

		List targetList = new ArrayList<>();
		targetList.add("20268");
		targetList.add("226503");
		targetList.add("157122");
		targetList.add("313013");
		System.out.println(targetList);
		for (Object str : targetList) {
			System.out.println((String) str);
		}

		List<? super Integer> list = new ArrayList<>();
		list.add(1);

		Collections.sort(targetList);
		System.out.println(targetList);

		System.out.println(MD5Utils.getMD5("123").length());

		try {
			System.out.println(1/0);

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			System.out.println(stringWriter.toString());

		}


	}
}
