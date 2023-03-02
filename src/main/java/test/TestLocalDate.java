package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

/**
 * @author mal
 * @date 2023-01-08 10:24
 */
public class TestLocalDate {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.parse("2023-01-10 00:00:00", dateTimeFormatter));
        LocalDate startDate = LocalDate.parse("2023-01-08");
        LocalDate endDate = LocalDate.parse("2023-01-08");

        LocalDate start = startDate;
        do {
            System.out.println(start);
            start = start.plusDays(1L);
        } while (!start.isAfter(endDate));

        System.out.println(start.isEqual(endDate));

        DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyyMM");
        //LocalDate parse = LocalDate.parse("202305"+"01", yyyyMM);
        //System.out.println(parse);

         final DateTimeFormatter PARSER = new DateTimeFormatterBuilder()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendValue(MONTH_OF_YEAR, 2)
                .toFormatter();
        YearMonth now = yyyyMM.parse("202305",YearMonth::from);

        //YearMonth now = YearMonth.parse("202305", PARSER);
        System.out.println(now);

        //YearMonth now = YearMonth.now();
        System.out.println(now.getMonth().getDisplayName(TextStyle.FULL, new Locale("zh","hk")));

        System.out.println(now);
    }
}
