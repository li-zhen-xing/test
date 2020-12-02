import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteTest{
    String path="D:\\exam";
    @Test
    public void testWrite03(){
        //1.创建一个工作蒲
        Workbook workbook=new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet=workbook.createSheet("统计表");
        //3.创建一个行
        Row row1=sheet.createRow(0);
        //4.创建一个单元格
        Cell cell = row1.createCell(0);
        cell.setCellValue("今日新增观众");
        //(1,2)
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue("666");
        //第二行（2,1）
        Row row2=sheet.createRow(1);
        //4.创建一个单元格
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(s);

        //生成一张表
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "观众统计表.xls");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("输出完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrite07(){
        //1.时间
        long begin=System.currentTimeMillis();
        /**
         * HSSFWorkbook是先从内存读取然后再存储支持格式为xls但是一次插入数据不能超过65536超过则报错
         * XSSFWorkbook是从硬盘中直接存储支持格式为xlsx插入速度明显较慢但是一次插入数据没有限制
         */
        //创建一个蒲
        Workbook workbook=new XSSFWorkbook();
        //创建表
        Sheet sheet=workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row=sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path+"BigData.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            Long end=System.currentTimeMillis();
            System.out.println((double)(end-begin)/1000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrite07S(){
        //1.时间
        long begin=System.currentTimeMillis();
        /**
         * HSSFWorkbook是先从内存读取然后再存储支持格式为xls但是一次插入数据不能超过65536超过则报错
         * XSSFWorkbook是从硬盘中直接存储支持格式为xlsx插入速度明显较慢但是一次插入数据没有限制
         * SXSSFWorkbook速度和容量都可以就是会产生临时文件需要清除
         */
        //创建一个蒲
        Workbook workbook=new SXSSFWorkbook();
        //创建表
        Sheet sheet=workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row=sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path+"BigDataS.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            //清除临时文件
            ((SXSSFWorkbook) workbook).dispose();
            Long end=System.currentTimeMillis();
            System.out.println((double)(end-begin)/1000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}