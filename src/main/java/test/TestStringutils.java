package test;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author mal
 * @date 2021-05-06 15:50
 */
public class TestStringutils {

    public static void main(String[] args) {
        String s = "2 3 5";
        String[] split = StringUtils.split(s);
        System.out.println(split);

        String right = StringUtils.right("", 5);
        System.out.println(right);

        String sql = "select venue_id AS venue_id, SUM(in_total_num) - SUM(out_total_num) AS stay_num" +
                "from stat.t_entry_info_hour_impulse" +
                "where venue_id = #{param.venueId}" +
                "and stat_date = #{param.date}" +
                "and stat_hour <= HOUR(NOW())" +
                "group by venue_id";

        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("venueId", 123L);
        objectObjectHashMap.put("date", "2021-05-27");

        System.out.println(selectBySql(sql,objectObjectHashMap));
    }


    public static String selectBySql(String sql, Map<String, Object> params) {
        // 处理数组参数和 Collection 参数
        for (Map.Entry entry : params.entrySet()) {
            String paramKey = "#{param." + entry.getKey() + "}";
            if (sql.contains(paramKey)) {
                Object value = entry.getValue();
                Collection collection;
                if (value instanceof Collection) {
                    collection = (Collection) value;
                } else if (value instanceof Object[]) {
                    collection = Arrays.asList((Object[]) value);
                } else {
                    continue;
                }

                StringBuilder union = new StringBuilder();
                for (Object object : collection) {
                    if (union.length() > 0) {
                        union.append(",");
                    }
                    if (object instanceof String) {
                        union.append("'").append(object).append("'");
                    } else {
                        union.append(object);
                    }
                }

                sql = sql.replaceAll(Pattern.quote(paramKey), union.toString());
            }
        }
        //设置返回值
        return sql;
    }



}
