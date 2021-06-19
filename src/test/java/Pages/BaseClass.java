package Pages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ExcelFolder.TestResultExcel;

public class BaseClass {
	

	public static WebDriver driver;
	public static WebElement product;
	
	public static boolean isPass = false; 
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static String testName; 
	public static String testResultMessage="";
	
	TestResultExcel testResultExcel = new TestResultExcel();
	XSSFSheet Sheet; 
	public static ArrayList<String> TestResult = new ArrayList<String>();
	TestResultExcel testResultWriteExcel = new TestResultExcel();
	
	
	@BeforeSuite
	public void openBrowser() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Sheet = testResultExcel.openExcel();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hepsiburada.com/");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		extent = new ExtentReports("./TestResult/TestResult.xlsx",true);
		extentTest = extent.startTest("In Hepsiburada, the study of liking the product with the login user and adding the favorite product to the cart");
		
	}
	
	@AfterSuite
	public void closeBrowser() throws IOException {
		
		testResultWriteExcel.WriteExcel(Sheet, TestResult);
		driver.close();
		extent.endTest(extentTest);
		extent.flush();
	}
	
	@BeforeMethod
	public void StartTest() {
		
		isPass = false;
	}
	
	@AfterMethod
	public void EndTest() {
		
		if (isPass == true) {
			extentTest.log(LogStatus.PASS,testResultMessage);
				
		}else {
			extentTest.log(LogStatus.FAIL,testResultMessage);
		}
	}
	
	public void Click(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elementBy = wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
        	elementBy.click();	
		} catch (NoSuchElementException e) {
			//error log
		}
        
    }
	
	public void FillIn(By element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elementBy = wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
        	elementBy.sendKeys(text);
		} catch (NoSuchElementException e) {
			//error log
		}
    }
	
	public void Displayed(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elementBy = wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
        	Assert.assertTrue(elementBy.isDisplayed());
		} catch (NoSuchElementException e) {
			//error log
		}
	}
	
	public void WaitVisibil(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elementBy = wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        try {
        	Assert.assertTrue(elementBy.isDisplayed());
		} catch (NoSuchElementException e) {
			//error log
		}
	}
	
	public void WaitClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elementBy = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
        try {
        	Assert.assertTrue(elementBy.isDisplayed());
		} catch (NoSuchElementException e) {
			//error log
		}
	}
	
}

















