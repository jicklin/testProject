package test;

/**
 * @author mal
 * @date 2021-04-29 16:00
 */
public class TestInterger {

    public static void main(String[] args) {
        Integer a = 129;
        Integer b = 129;
        System.out.println(a.equals(b));


        System.out.println(1 / 2);
        System.out.println(2 / 2 == 0);

        System.out.println(formateOverTime(140));

    }

    /**
     * 格式化一下分钟成 xx小时 xx分钟
     * @param overMinutes
     * @return
     */
    public static String formateOverTime(Integer overMinutes) {
        if (overMinutes == null) {
            return "";
        }
        if (overMinutes / 60 == 0) {
            return overMinutes + "分钟";
        }

        if ((overMinutes % 60) == 0) {
            return (overMinutes / 60) + "小时";
        }
        return (overMinutes / 60) + "小时" + (overMinutes % 60) + "分钟";
    }

}
