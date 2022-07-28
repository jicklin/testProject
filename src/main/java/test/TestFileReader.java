package test;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestFileReader {

	public static void main(String[] args) {

		try (FileReader reader = new FileReader(new File("E:\\ideaWorkspace\\testProject\\src\\main\\java\\test\\crowdList.txt"))){
			char[] buf = new char[100];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = reader.read(buf)) != -1) {
				String str = new String(buf);
				sb.append(str);
				buf = new char[100];

			}

			List<String> strings = JSON.parseArray(sb.toString(), String.class);
			System.out.println(strings.size());
			Set<String> deSet = new HashSet<>(strings);
			System.out.println(deSet.size());


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
