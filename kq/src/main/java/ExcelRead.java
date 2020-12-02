import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.FileInputStream;

public class ExcelRead {
    String path="D:\\exam";

    @Test
    public void testRead03() throws Exception{
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(path + "观众统计表.xls");
        //1.创建一个工作蒲
        Workbook workbook=new HSSFWorkbook(fileInputStream);
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

    public void testCellType() throws Exception{
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(path + "Test.xlsx");
        //1.创建一个工作蒲
        Workbook workbook=new HSSFWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        //获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle!=null){
            //当前行中有多少列
            int cells = rowTitle.getPhysicalNumberOfCells();
            for (int i = 0; i < cells; i++) {

            }
        }
    }
}
