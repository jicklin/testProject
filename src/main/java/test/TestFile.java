package test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class TestFile {
	public static void main(String[] args)  {
		try {
			File tempFile = File.createTempFile("malin_temple", "xlsx");
			System.out.println(tempFile.getAbsolutePath());
			System.out.println(tempFile.getPath());


			HttpServletResponse response = null;

			SXSSFWorkbook workbook = null;
			OutputStream outputStream = null;
			try {
				outputStream = response.getOutputStream();
				//创建工作簿
				workbook = new SXSSFWorkbook();
				// 打开压缩功能 防止占用过多磁盘
				workbook.setCompressTempFiles(true);

				// 创建一个工作表
				Sheet sheet = workbook.createSheet("表名");
				// 创建一行
				Row titleRow = sheet.createRow(0);
				// 创建一个单元格
				Cell cell = titleRow.createCell(0);
				// 给单元格赋值
				cell.setCellValue("内容");

				// 将工作簿写入输出流
				workbook.write(outputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (workbook != null) {
					//使用完毕后将产生的临时文件删除 防止将磁盘搞满
					workbook.dispose();
				}
				if (outputStream != null) {
					outputStream.close();

				}


			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
