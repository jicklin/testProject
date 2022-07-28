package test;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.Date;
import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {
		System.out.println(new Random().nextDouble());
		System.out.println(new Random().nextInt(1000));

		System.out.println(new DateTime().withTime(15, 0, 0, 0));

		DateTime createTime = new DateTime(new Date());
		System.out.println(createTime);

		DateTime afterDate = createTime.plusDays(1);
		System.out.println(afterDate);

		System.out.println(createTime.isAfter(afterDate));

		boolean b = afterDate.getDayOfWeek() == DateTimeConstants.SUNDAY;
		System.out.println(b);

		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(random.nextInt(1000));

		}


	}
}
