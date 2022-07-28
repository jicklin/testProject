package test.db;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StopWatch;

import java.sql.*;
import java.util.*;

/**
 * @author mal
 * @date 2021-11-24 14:45
 */
public class TestDb {

    public static void main(String[] args) throws SQLException {


        //TimerTask timerTask = new TimerTask() {
        //    @Override
        //    public void run() {
        //        delete();
        //    }
        //};
        //
        //Timer timer = new Timer();
        //timer.schedule(timerTask, 1000, 50000);
        delete();


    }

    public static void delete() {
        Statement statement=null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://218.244.136.36:3306/venue?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","uop_app","0jhmFVdl8ix0bn-^");
            conn = DriverManager.getConnection("jdbc:mysql://rdsp44vqk0907gch8zsyo.mysql.rds.aliyuncs.com:3306/venue","query","QuerYx_1588");
            statement = conn.createStatement();
            //String sql = "delete from bank_reconciliation where reconciliation_date >= DATE_SUB(curdate(),interval 3 day );";
            String sql = "select distinct\n" +
                    "a.id, a.batch_id, a.type, a.list_type, ifnull(ifnull(a.mobile_num, c.contact_phone), d.mobile_num) mobile_num, a.cust_id, a.cust_name, a.state, a.start_date, a.end_date,\n" +
                    "a.center_id, a.products, a.remark, a.create_time, a.create_staff_id, a.update_time, a.update_staff_id,d.net_user_id, e.username\n" +
                    "from limit_list a\n" +
                    "left join customer c on a.cust_id = c.cust_id\n" +
                    "left join net_user_cards b on b.status = '1' and if(b.end_date is null,  b.start_date < now() ,  now() between b.start_date and b.end_date) and cast(a.cust_id as char )= b.venue_cust_id\n" +
                    "left join net_user d on b.net_user_id = d.net_user_id\n" +
                    "left join net_user_account e on b.net_user_id = e.net_user_id\n" +
                    "where a.list_type = 2\n" +
                    "and a.state = 1\n" +
                    "and now() between a.start_date and a.end_date;";
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<Map> result = new ArrayList<>();
            while (resultSet.next()) {
                HashMap<String, Object> hashMap = new HashMap<>();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String catalogName = metaData.getColumnName(i+1);
                    hashMap.put(catalogName, resultSet.getObject(catalogName));

                }
                result.add(hashMap);
            }
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
