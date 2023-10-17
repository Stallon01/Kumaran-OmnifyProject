package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;


public class EmployeePage  extends BaseClass{
	
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pim;
	
	@FindBy (xpath="//li/a[text()='Add Employee']")
	private WebElement addEmployee;
	
	@FindBy (name="firstName")
	private WebElement firstName;
	
	@FindBy (name="middleName")
	private WebElement middleName;
	
	@FindBy (name="lastName")
	private WebElement lastName;
	
	@FindBy (xpath = "(//input)[6]")
	private WebElement eIDText;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement save;
	
	
	@FindBy(xpath = "//li/a[text()='Employee List']")
	private WebElement employeeList;
	
	@FindBy(xpath = "(//input)[3]")
	private WebElement employeeID;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;
	
	public By Toggle = By.xpath("//input[starts-with(@class,'oxd-input')]");
	
	public By AddEmployee = By.xpath("//li/a[text()='Add Employee']");
	
	
	@FindBy(xpath = "//div[@class=\"orangehrm-container\"]//div[@class=\"oxd-table-body\"]//div[starts-with(@class,'oxd-table-card')][1]/div/div/div")
	private List<WebElement> firstRowSearchResult;
	
	@FindBy(xpath = "//*[@class='--active oxd-userdropdown']//p")
	private WebElement profileOption;
	
	
	@FindBy(xpath = "//*[@class='--active oxd-userdropdown']//a[text() = 'Logout']")
	private WebElement logoutMenu;
	
	
	public WebElement getPim() {
		return pim;
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement geteIDText() {
		return eIDText;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getEmployeeList() {
		return employeeList;
	}

	public WebElement getEmployeeID() {
		return employeeID;
	}
	
	
	public EmployeePage() {
		
		PageFactory.initElements(driver, this);
	}

	public By getToggle() {
		return Toggle;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public List<WebElement> getFirstRowSearchResult() {
		return firstRowSearchResult;
	}

	public WebElement getProfileOption() {
		return profileOption;
	}

	public WebElement getLogoutMenu() {
		return logoutMenu;
	}

	

	
	
	
	
	
	
	
	
	
	

}
