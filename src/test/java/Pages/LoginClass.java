package Pages;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ExcelFolder.GetUserData;
import Pages.BaseClass;

public class LoginClass extends BaseClass{

	public void Login() throws IOException {
		GetUserData getUserData = new GetUserData();
		String username =  getUserData.getUsername();
		String password = getUserData.getPassword();
		WebDriverWait wait = new WebDriverWait(driver, 80);
		
		WebElement pageIcon = driver.findElement(By.xpath("//a[@title='Hepsiburada']//*[local-name()='svg']"));
		wait.until(ExpectedConditions.visibilityOf(pageIcon));
		
		Assert.assertTrue(pageIcon.isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.hepsiburada.com/");
		extentTest.log(LogStatus.PASS, "Homepage has been opened successfully");
		
		Click(By.id("myAccount"));
		Click(By.id("login"));
		Displayed(By.id("txtUserName"));
		Displayed(By.id("txtPassword"));
		Displayed(By.id("btnLogin"));
		extentTest.log(LogStatus.PASS, "Login page has been opened successfully");
		
		Click(By.id("txtUserName"));
		FillIn(By.id("txtUserName"), username);
		Click(By.id("txtPassword"));
		FillIn(By.id("txtPassword"), password);
		Click(By.id("btnLogin"));
		
		WebElement usernameOnpage = driver.findElement(By.xpath("//a[@title='Hesabım']"));
		wait.until(ExpectedConditions.visibilityOf(usernameOnpage));
		Displayed(By.xpath("//a[@title='Hesabım']"));
		
		extentTest.log(LogStatus.PASS,"Login is successful, page viewed");
	}
	
	
}
