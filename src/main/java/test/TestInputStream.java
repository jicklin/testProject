package test;

import java.io.*;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2018/12/12
 */
public class TestInputStream {

    public static void main(String[] args) {
        /*StringWriter sw = new StringWriter();

        BufferedWriter bufferedWriter = new BufferedWriter(sw);
        try {
            bufferedWriter.write("123");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sw.getBuffer().toString());*/

        OutputStream outputStream = new ByteArrayOutputStream();
        BufferedOutputStream bo = new BufferedOutputStream(outputStream);
        try {
            bo.write("hello".getBytes("utf-8"));
            bo.write("\r".getBytes("utf-8"));
            bo.write("hello2".getBytes("utf-8"));
            bo.flush();
            System.out.println(((ByteArrayOutputStream) outputStream).toString("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
