package test.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.*;

/**
 * @author mal
 * @date 2023-02-20 17:34
 */
public class TestEasyExcel {


    public static void main(String[] args) {


        String content = readFile();

        System.out.println(content);

        EasyExcel.read();


    }

    private static String readFile() {
        String content;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("classpath:test/file/b.json")))) {
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);

            }
            return sb.toString();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static class  ExportData{

        @ExcelProperty("")
        private String camerName;
    }


}
