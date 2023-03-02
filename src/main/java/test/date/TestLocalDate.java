package test.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/**
 * @author mal
 * @date 2023-03-02 11:07
 */
public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.getMonth().getValue());

        System.out.println(now.with(DayOfWeek.MONDAY));
        System.out.println(now.with(DayOfWeek.SUNDAY));

        System.out.println(now.withDayOfMonth(1));
        System.out.println(now.withDayOfMonth(1));
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(now.with(ChronoField.DAY_OF_MONTH, 1));

        Period between = Period.between(now.with(DayOfWeek.MONDAY), now.with(DayOfWeek.SUNDAY));
        System.out.println(now.with(DayOfWeek.MONDAY).toEpochDay());
        System.out.println(now.with(DayOfWeek.SUNDAY).toEpochDay());
        System.out.println(between.getDays());
    }
}
