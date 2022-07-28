package test;

import java.util.Arrays;
import java.util.Optional;

public class ArrTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(arr[1]);

        Object[] objects = new Object[5];
        System.out.println(Arrays.toString(objects));
        objects[4] = 1;

        int[] ints = new int[5];
        System.out.println(Arrays.toString(ints));

        TestXml.Student student = new TestXml.Student();
        student.setName("麦晓琳");

        System.out.println(Optional.ofNullable(student).map(TestXml.Student::getName).orElse("无名氏"));


        //Integer type = null;
        //
        //switch (type) {
        //    case 1:
        //        System.out.println(1);
        //        break;
        //    case 2:
        //        System.out.println(2);
        //        break;
        //    default:
        //        System.out.println(3);
        //
        //}
    }
}
