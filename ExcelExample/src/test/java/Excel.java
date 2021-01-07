import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\senth\\eclipse-workspace\\ExcelExample\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://adactinhotelapp.com/");
		File loc = new File("C:\\Users\\senth\\eclipse-workspace\\ExcelExample\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream); 
		Sheet s = w.getSheet("Sheet1");
		for (int i = 1; i <s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				
				DataFormatter format = new DataFormatter();
				String fo = format.formatCellValue(c);
				if (j==0) {
				driver.findElement(By.id("username")).sendKeys(fo);
				}
				else {
					driver.findElement(By.id("password")).sendKeys(fo);
				}
				
			}
			driver.findElement(By.id("login")).click();
			
			
		}
		
		
		
	}

}
