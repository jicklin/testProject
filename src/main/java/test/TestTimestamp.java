package test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimestamp {


	public static void main(String[] args) throws ParseException {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		System.out.println(timestamp);
		SimpleDateFormat SDF_YMD = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(SDF_YMD.parse(String.valueOf(timestamp)));
	}
}
