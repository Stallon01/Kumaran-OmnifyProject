package com.test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.baseclass.BaseClass;
import com.pages.Login;
import com.pages.EmployeePage;

public class Test extends BaseClass {
	Login l=null;
	EmployeePage p = null;
	WebDriver driver;
	WebDriverWait wait = null;
	List<HashMap<String, String>> data=null;
	
	@BeforeClass

	public void beforeClass() throws IOException, Throwable {
		driver = launchBrowser(getProperty("browser"));
		launchApp(getProperty("url"));
		 data = getExcelData(System.getProperty("user.dir")+"\\Data\\Data.xlsx", "sheet1");
	}
	
	
	@org.testng.annotations.Test
	public void tc1() throws IOException, Throwable {
		
		l=new Login();
		p=new EmployeePage();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		enterText(l.getUsername(), getProperty("username"));
		enterText(l.getPassword(), getProperty("password"));
		clickButton(l.getLogin());
		Thread.sleep(5000);	
		
		WebElement expandToggle = driver.findElement(By.xpath("//input[starts-with(@class,'oxd-input')]"));
		wait.until(ExpectedConditions.presenceOfElementLocated(p.Toggle));
		if(!expandToggle.getAttribute("class").equals("oxd-input oxd-input--active")) {
			expandToggle.click();
		}
		
		
		clickButton(p.getPim());
		wait.until(ExpectedConditions.presenceOfElementLocated(p.AddEmployee));
		for(int i=1;i<data.size();i++) {
		Thread.sleep(3000);	
		clickButton(p.getAddEmployee());
		wait.until(ExpectedConditions.presenceOfElementLocated(p.AddEmployee));
		enterText(p.getFirstName()	, data.get(i).get("FirstName"));
		enterText(p.getMiddleName()	, data.get(i).get("MiddleName"));
		enterText(p.getLastName()	, data.get(i).get("LastName"));
		String eID=p.geteIDText().getAttribute("value");
		clickButton(p.getSave());
		Thread.sleep(3000);
		clickButton(p.getEmployeeList());
		clickButton(p.getEmployeeList());
		Thread.sleep(3000);
		enterText(p.getEmployeeID(), eID);
		clickButton(p.getSearchBtn());
		String text = p.getFirstRowSearchResult().get(2).getText();
		System.out.println(text);
		Assert.assertEquals(text, (data.get(i).get("FirstName")+" "+data.get(i).get("MiddleName")).trim());
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		p.getProfileOption().click();
		p.getLogoutMenu().click();
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}

}
