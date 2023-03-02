package test;

import net.sf.cglib.core.Local;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestLocalTime {

	public static void main(String[] args) {

		/*System.out.println(LocalDate.now());
		System.out.println(LocalDate.now().getMonth());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(formatter.format(LocalDate.now()));
		System.out.println(LocalDate.now().plusMonths(1));

		System.out.println(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

		System.out.println(LocalDateTime.now().toString());
*/

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.parse("2021-06-30 09:42:00", formatter2);
		System.out.println(localDateTime);
		LocalDateTime targetDateTime = localDateTime.plusSeconds(30);
		System.out.println(targetDateTime);
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now().isBefore(targetDateTime));

		LocalDate startLocal = LocalDate.of(2022, 4, 9);
		long days = LocalDate.now().toEpochDay() - startLocal.toEpochDay();
		System.out.println(days /7);
		System.out.println(days %7);







	}
}
