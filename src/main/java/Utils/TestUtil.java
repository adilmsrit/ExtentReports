package Utils;

import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static int PAGE_LOAD_TIMEOUT = 20;
    public static int IMPLICIT_WAIT = 10;

    static Workbook book;
    static Sheet sheet;


    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String dataFilePath, String sheetName) {
        FileInputStream file = null;

        try {
            file = new FileInputStream(dataFilePath);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File("E:\\TestPractice\\src\\main\\java\\com.crm.qa.screenshots\\" + System.currentTimeMillis() + ".png"));
    }
}
