package test;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author mal
 * @date 2021-10-22 17:28
 */
public class TestDateFoemateUtils {

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
    }
}
