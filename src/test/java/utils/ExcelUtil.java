package utils;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

public static Object[][] getData() throws Exception {
FileInputStream fis =
new FileInputStream("src/test/resources/TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("Sheet1");
int rows = sheet.getLastRowNum();
int cols = sheet.getRow(0).getLastCellNum();
Object[][] data = new Object[rows][cols];
for (int i = 1; i <= rows; i++) {
for (int j = 0; j < cols; j++) {
data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
}
}

wb.close();
return data;
}

}

