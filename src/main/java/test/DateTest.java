package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/7/9
 */
public class DateTest {

    public static void main(String[] args) {

        /*String dateStr = "2019-77-09";

        Date date = Date.valueOf(dateStr);
        System.out.println(date);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //计算日期差
        Date date1 = Date.valueOf("2019-07-01");
        Date date2 = Date.valueOf("2019-07-02");
        long day = (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24);
        System.out.println(day);
*/
        String dateS = "20200710";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(dateS, dateTimeFormatter);
        LocalDate afterDate = localDate.plusDays(3);
        System.out.println(afterDate.format(dateTimeFormatter));
        Date chargeDate = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            chargeDate = dateFormat.parse("2021-07-23 22:10:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<ImmutablePair<Date, Date>> immutablePairs = calculateStartAndEndDateByDay(new Date(), chargeDate);
        String s = JSON.toJSONString(immutablePairs, SerializerFeature.WriteDateUseDateFormat);

        System.out.println(s);

    }


    /**
     * 按天算一下起始时间
     * @param startTime
     * @param chargeTime
     * @return
     */
    private static List<ImmutablePair<Date, Date>> calculateStartAndEndDateByDay(java.util.Date startTime, java.util.Date chargeTime) {

        List<ImmutablePair<java.util.Date, Date>> list = Lists.newArrayList();
        Calendar startDateCal = Calendar.getInstance();
        startDateCal.setTime(startTime);

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(startTime);
        endDateCal.set(Calendar.HOUR_OF_DAY, 23);
        endDateCal.set(Calendar.MINUTE, 59);
        endDateCal.set(Calendar.SECOND, 59);
        endDateCal.set(Calendar.MILLISECOND, 0);
        while (endDateCal.getTime().before(chargeTime)) {
            list.add(ImmutablePair.of(startDateCal.getTime(), endDateCal.getTime()));
            startDateCal.add(Calendar.DATE, 1);
            startDateCal.set(Calendar.HOUR_OF_DAY, 0);
            startDateCal.set(Calendar.MINUTE, 0);
            startDateCal.set(Calendar.SECOND, 0);
            startDateCal.set(Calendar.MILLISECOND, 0);

            endDateCal.add(Calendar.DATE, 1);
            endDateCal.set(Calendar.HOUR_OF_DAY, 23);
            endDateCal.set(Calendar.MINUTE, 59);
            endDateCal.set(Calendar.SECOND, 59);
            endDateCal.set(Calendar.MILLISECOND, 0);
        }

        // 可能还有一个本来就是当天的
        list.add(ImmutablePair.of(startDateCal.getTime(), chargeTime));

        System.out.println(3 % 2);
        return list;


    }
}
