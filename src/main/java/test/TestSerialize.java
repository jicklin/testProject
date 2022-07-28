package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2018/12/28
 */
public class TestSerialize implements Serializable {


    private static final long serialVersionUID = -2604898120912697407L;

    public int num = 30;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("hahah.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            TestSerialize serialize = new TestSerialize();
            oos.writeObject(serialize);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
