package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {

		Calendar instance = Calendar.getInstance();
		while (instance.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			instance.add(Calendar.DAY_OF_WEEK, -1);
		}
		List<Date> dates = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			dates.add(instance.getTime());
			instance.add(Calendar.DAY_OF_WEEK, 1);
		}

		System.out.println(dates);

	}
}
