package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/7/8
 */
public class PatternTest {

    private static Pattern TYPE_TEL_ORG_PATTERN = Pattern.compile("^(1[0-9]{10})$");


    private static final Pattern INFINITESIMAL_PRICE = Pattern.compile("-1-(\\d+)");

    public static void main(String[] args) {


        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\18048422\\Documents\\ffefbe1dc8e945a18bf799198dc7bc4b.txt")))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
                if (temp.contains("\uFEFF")) {
                    System.out.println("1");
                    temp = temp.replace("\uFEFF", "");
                }
                System.out.println(TYPE_TEL_ORG_PATTERN.matcher(temp).matches());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }*/
      /*  String target = null;
        System.out.println(TYPE_TEL_ORG_PATTERN.matcher(target).matches());*/

        String target = "-1-500";
        Matcher matcher = INFINITESIMAL_PRICE.matcher(target);
        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            String group = matcher.group(1);
            System.out.println(group);
        }
    }
}
