package com.ll;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.FileInputStream;
import com.ll.Util.util;
import com.ll.dao.PersonDao;
import com.ll.domain.Person;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;


public class read {

    String path="D:\\";

    @Test
    public void testRead03() throws Exception{
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(path + "Test.xlsx");
        //1.创建一个工作蒲
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        //2.创建一个工作表
        Sheet sheet=workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        Cell cell1 = row.getCell(1);
        System.out.println(cell);
        System.out.println(cell1);
    }

    @Test
    public void testRead07() throws Exception{
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(path + "BigData.xlsx");
        //1.创建一个工作蒲
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        //2.创建一个工作表
        Sheet sheet=workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        Cell cell1 = row.getCell(1);
        System.out.println(cell);
        System.out.println(cell1);
    }

    @Test
    public void testCellType() throws Exception{
        SqlSession sqlSession = util.getSqlSession();
        PersonDao dao = sqlSession.getMapper(PersonDao.class);
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(path + "Test.xlsx");
        //1.创建一个工作蒲
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        //统计一共多少行
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            //当前行中有多少列
            int cells = row.getPhysicalNumberOfCells();
            //定义一个list接受所有属性
            ArrayList<String> property = new ArrayList<>();
            //遍历当前行中的所有列
            for (int z = 0; z < cells; z++) {
                Cell cell = row.getCell(z);
                String temp=cell+"";
                property.add(temp);
            }
            Person person = new Person();
            person.construct(property);
            dao.insertPerson(person);
            sqlSession.commit();
        }
        fileInputStream.close();
    }
}

