package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/7/2
 */
public class TestReuseInputStream {

    public static void main(String[] args) throws IOException {

        String text = "测试多次读取inputStream内容";

        InputStream rawInputStream = new ByteArrayInputStream(text.getBytes());
        byte[] readArray = new byte[1024];

        rawInputStream.mark(0);

        int readCount1 = rawInputStream.read(readArray);
        rawInputStream.reset();

        int readCount2 = rawInputStream.read(readArray);
        rawInputStream.reset();

        int readCount3 = rawInputStream.read(readArray);
        System.out.println(readCount1);
        System.out.println(readCount2);
        System.out.println(readCount3);

        String content = "BoyceZhang!";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());

// 判断该输入流是否支持mark操作
        if (!inputStream.markSupported()) {
            System.out.println("mark/reset not supported!");
        }
        int ch;
        boolean marked = false;
        while ((ch = inputStream.read()) != -1) {

            //读取一个字符输出一个字符
            System.out.print((char)ch);
            //读到 'e'的时候标记一下
            if (((char)ch == 'e')& !marked) {
                inputStream.mark(content.length());  //先不要理会mark的参数
                marked = true;
            }

            //读到'!'的时候重新回到标记位置开始读
            if ((char)ch == '!' && marked) {
                inputStream.reset();
                marked = false;
            }
        }

    }





}
