package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/5
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, 0);
       /* calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 10);
        System.out.println(calendar.getTime());

        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(1);
        collection.add(1);
        System.out.println(collection);
        System.out.println(ArrayUtils.toString(collection));*/
        //System.out.println(calendar.getTime());

        //System.out.println(getDateAfterSomeDay(new Date(),2));


        Date[] firstAndLastDate = getFirstAndLastDate(calendar.getTime(), "w", 1);
        System.out.println(JSON.toJSONString(firstAndLastDate, SerializerFeature.WriteDateUseDateFormat));

    }


    public static Date getDateAfterSomeDay(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }


    public static Date[] getFirstAndLastDate(Date currentDate, String unit, int num) {

        if (unit == null || unit.length() == 0) {
            throw new IllegalArgumentException("计算时间单位不能为空");
        }
        Date startDate = null;
        Date endDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);

        // 当前所在日期每周的开始和结束日期
        if ("w".equalsIgnoreCase(unit)) {
            int d = 0;
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                d = -6;
            } else {
                d = 2 - cal.get(Calendar.DAY_OF_WEEK);
            }
            cal.add(Calendar.DAY_OF_WEEK, d);
            startDate = trim(cal.getTime());
            cal.add(Calendar.DAY_OF_WEEK, 6);
            endDate = endTime(cal.getTime());
            cal.setTime(startDate);
            cal.add(Calendar.WEEK_OF_YEAR, 1 - num);
            startDate = cal.getTime();

        }

        // 当前月的开始结束日期
        if ("m".equalsIgnoreCase(unit)) {
            cal.set(Calendar.DAY_OF_MONTH, 1);
            startDate = trim(cal.getTime());
            cal.add(Calendar.MONTH, 1);
            cal.add(Calendar.DAY_OF_YEAR, -1);
            endDate = endTime(cal.getTime());
            cal.setTime(startDate);
            cal.add(Calendar.MONTH, 1 - num);
            startDate = cal.getTime();
        }

        // 当前年的开始结束日期
        if ("y".equalsIgnoreCase(unit)) {
            cal.set(Calendar.DAY_OF_YEAR, 1);
            startDate = trim(cal.getTime());
            cal.add(Calendar.DAY_OF_YEAR, -1);
            cal.add(Calendar.YEAR, 1);
            endDate = endTime(cal.getTime());
            cal.setTime(startDate);
            cal.add(Calendar.YEAR, 1 - num);
            startDate = cal.getTime();
        }

        return new Date[]{startDate, endDate};
    }

    /**
     * 把日期的时分秒改成 00:00:00
     *
     * @param date
     * @return
     */
    public static Date trim(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 把日期的时分秒改成 23:59:59
     *
     * @param date
     * @return
     */
    public static Date endTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
