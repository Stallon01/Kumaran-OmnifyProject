package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver launchBrowser(String browser) throws Throwable {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Browser name not available");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		return driver;
	}

	public static void launchApp(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static String getProperty(String key) throws Throwable, IOException {

		Properties p = new Properties();
		p.load(new FileInputStream(
				new File(System.getProperty("user.dir")+"\\Config\\SystemData.properties")));

		return p.getProperty(key);
	}

	public static List<HashMap<String,String>> getExcelData(String ExcelPath,String sheetName) throws Throwable{
		List<HashMap<String,String>> MapList=null;
		int i=0;
			File f= new File(ExcelPath);
			
			FileInputStream f1 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(f1);
			
			MapList = new ArrayList<HashMap<String, String>>();
			
			org.apache.poi.ss.usermodel.Sheet sheet =w.getSheet(sheetName);
			
			Row headRow = sheet.getRow(0);
			
			
			for (i = 0; i < sheet.getPhysicalNumberOfRows();i++) {
				HashMap<String,String>map = new HashMap<String, String>();
				
				for (int j = 0; j < headRow.getPhysicalNumberOfCells(); j++) {
					
					Cell cell = sheet.getRow(i).getCell(j);
					
					
					map.put(headRow.getCell(j).getStringCellValue(), cell.getStringCellValue());
					
					
				
			}
			
			
			MapList.add(map);
			
		
		
		
	}
			return MapList;
	
}
	
	public static  void enterText(WebElement e,String name) {

		e.sendKeys(name);
	}
	
	public static  void clickButton(WebElement e) {

		e.click();
	}
}
