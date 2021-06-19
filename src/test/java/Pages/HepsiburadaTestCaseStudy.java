package Pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;

import ExcelFolder.TestResultExcel;
import Pages.BaseClass;

public class HepsiburadaTestCaseStudy extends BaseClass {

	TestResultExcel writeResultToExcel = new TestResultExcel();
	
	@Test(priority = 1)
	public void HomePageCheck() {
		StartReport("HomePage case is failed");
		//Check Homepage
		WebElement HepsiburadaLogo = driver.findElement(By.xpath("//a[@title='Hepsiburada']//*[local-name()='svg']"));
		assertTrue(HepsiburadaLogo.isDisplayed(), "Automation couldn't find <HepsiburadaLogo>");
		
		extentTest.log(LogStatus.PASS, "Login is succees");
		TestResult.add("HomePage successfully done");
		EndReport("HomePage successfully done");
	}
	
	@Test(priority = 2)
	public void Login() throws IOException {
		StartReport("Login case is failed");
		// Login 
		LoginClass loginClass = new LoginClass();
		loginClass.Login();
		
		extentTest.log(LogStatus.PASS, "Login is succees");
		TestResult.add("Login successfully done");
		EndReport("Login successfully done");
	}
	
	@Test(priority = 3)
	public void Search() {
		StartReport("Search case is failed");
		// Search 
		Click(By.id("SearchBoxOld"));
		FillIn(By.className("desktopOldAutosuggestTheme-input"),"samsung");
		WebElement searchBtn = driver.findElement(By.id("SearchBoxOld")).findElement(By.className("SearchBoxOld-buttonContainer"));
		
		// search elements checked
		Displayed(By.id("SearchBoxOld"));
		Displayed(By.className("desktopOldAutosuggestTheme-input"));
		searchBtn.click();
		
		extentTest.log(LogStatus.PASS, "Search is success");
		TestResult.add("Search successfully done");
		EndReport("Search successfully done");
	}
	
	@Test(priority = 4)
	public void ChoosePhoneAndMobilePhone() {
		StartReport("ChoosePhoneAndMobilePhone case is failed");
		// Choose phone and mobile phone
		WaitClickable(By.xpath("//label[normalize-space()='Telefon']"));
		Click(By.xpath("//label[normalize-space()='Telefon']"));		
		WaitClickable(By.xpath("//label[normalize-space()='Cep Telefonu']"));
		Click(By.xpath("//label[normalize-space()='Cep Telefonu']"));
		
		extentTest.log(LogStatus.PASS, "Choose is success");
		TestResult.add("ChoosePhoneAndMobilePhone case successfully done");
		EndReport("ChoosePhoneAndMobilePhone case successfully done");
	}
	
	@Test(priority = 5)
	public void ResultIsChecked() {
		StartReport("ResultIsChecked case is failed");
		// choices checked	
		WaitVisibil(By.xpath("//span[@class='search-results-title']"));
		assertTrue( driver.getTitle().contains("samsung")); 
			
		WaitVisibil(By.xpath("//span[@class='totalItems tolkien']"));
		assertTrue( driver.findElement(By.xpath("//span[@class='totalItems tolkien']")).getText().contains("ürün bulduk."));
		
		extentTest.log(LogStatus.PASS, "Telefon and Cep Telefonu clicked and results are displayed");
		TestResult.add("ResultIsChecked case successfully done");
		EndReport("ResultIsChecked case successfully done");
	}
	
	@Test(priority = 6)
	public void OpenPage2() {
		StartReport("OpenPage2 case is failed");
		//open page2
		WebDriverWait wait = new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space()='2']"))));
		WaitClickable(By.xpath("//a[normalize-space()='2']"));		
		Click(By.xpath("//a[normalize-space()='2']"));
		
		extentTest.log(LogStatus.PASS, "Page 2 opened success");
		TestResult.add("OpenPage2 case successfully done");
		EndReport("OpenPage2 case successfully done");
	}
	
	@Test(priority = 7)
	public void ChooseProduct() {
		StartReport("ChooseProduct case is failed");
		// click 5. product	
		By product5 = By.xpath("//li[5]//div[1]//a[1]");	
		WaitClickable(product5);
		Click(product5);
		
		extentTest.log(LogStatus.PASS, "product 5 clicked");
		TestResult.add("ChooseProduct case successfully done");
		EndReport("ChooseProduct case successfully done");
	}
	
	@Test(priority = 8)
	public void ProductAddFavorite(){
		StartReport("ProductAddFavorite case is failed");
		// Product add favorite my favorites
		By likeBtn = By.xpath("//div[@id='MyLists']/div/div//div/div");
		By likePopup = By.className("hb-toast-text");
		By productDetailPage = By.className("productDetailContent");
		
		// Product detail page checked
		WaitVisibil(productDetailPage);
		WaitClickable(likeBtn);		
		Click(likeBtn);
		
		// Product like message checked
		WaitVisibil(likePopup);
		assertEquals(driver.findElement(likePopup).getText(), "Ürün listenize eklendi.");
		
		extentTest.log(LogStatus.PASS, "Product add favorite");
		TestResult.add("ChooseProduct case successfully done");
		EndReport("ChooseProduct case successfully done");
	}
	
	@Test(priority = 9)
	public void CheckAddFavoriteMessage(){
		StartReport("CheckAddFavoriteMessage case is failed");		
		// Product like message checked
		By likePopup = By.className("hb-toast-text");
		WaitVisibil(likePopup);
		assertEquals(driver.findElement(likePopup).getText(), "Ürün listenize eklendi.");
		
		extentTest.log(LogStatus.PASS, "Add favorite meessage seen");
		TestResult.add("CheckAddFavoriteMessage case successfully done");
		EndReport("CheckAddFavoriteMessage case successfully done");
	}

	@Test(priority = 10)
	public void ClickMyFavorites() {
		StartReport("ClickMyFavorites case is failed");	
		//Go to my favorites page
		WebElement myProfile = driver.findElement(By.xpath("//div[@id='myAccount']"));
		WebElement myFavouritesBtn = driver.findElement(By.xpath("//div[@id='myAccount']")).findElement(By.xpath("//div[1]/div[2]/ul/li[5]/a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(myProfile).perform();
		WaitClickable(By.xpath("//div[@id='myAccount']/div[1]/div[2]/ul/li[5]/a"));
		myFavouritesBtn.click();
		
		extentTest.log(LogStatus.PASS, "My favorite page clicked");
		TestResult.add("ClickMyFavorites case successfully done");
		EndReport("ClickMyFavorites case successfully done");
	}
	
	@Test(priority = 11)
	public void CheckedMyFavoriteProduct() {
		StartReport("CheckedMyFavoriteProduct case is failed");	
		//my favorites page opened and my favorite product checked
		By myFavoritesPage = By.xpath("//body/div[@id='root']/div[@class='main']/div[@class='myList-main']/div[2]");
		WaitVisibil(myFavoritesPage);
		
		List<WebElement> favProducts = driver.findElement(By.xpath("//div[@class='product-list']")).findElements(By.xpath("div"));
		Assert.assertTrue(favProducts.size() > 0);

		extentTest.log(LogStatus.PASS, "My favorite product seen");
		TestResult.add("CheckedMyFavoriteProduct case successfully done");
		EndReport("CheckedMyFavoriteProduct case successfully done");
	}
	
	
	@Test(priority = 12)
	public void ProductAddMyCart(){
		StartReport("ProductAddMyCart case is failed");	
		
		List<WebElement> favProducts = driver.findElement(By.xpath("//div[@class='product-list']")).findElements(By.xpath("div"));
		
		//favorite product on mousehover
		for(int i = 0 ; i <= favProducts.size() ; i++) {
			 product = favProducts.get(0).findElement(By.xpath("//a/img"));
		}
		
		Actions action = new Actions(driver);
		action.moveToElement(product).perform();
		WebElement addCart = product.findElement(By.xpath("//span[contains(text(),'Sepete Ekle')]"));
		WaitClickable(By.xpath("//span[contains(text(),'Sepete Ekle')]"));
		addCart.click();
		
		//product added to cart message appears 
		By addCartPopup = By.xpath("//div[@class='hb-toast-text']");
		WaitVisibil(addCartPopup);
		Assert.assertEquals(driver.findElement(addCartPopup).getText(), "Ürün sepete eklendi");
		
		extentTest.log(LogStatus.PASS, "Product add to cart");
		TestResult.add("ProductAddMyCart case successfully done");
		EndReport("ProductAddMyCart case successfully done");
	}
	
	@Test(priority = 13)
	public void CheckedAddCartMessage(){
		StartReport("CheckedAddCartMessage case is failed");	
		//product added to cart message appears 
		By addCartPopup = By.xpath("//div[@class='hb-toast-text']");
		WaitVisibil(addCartPopup);
		Assert.assertEquals(driver.findElement(addCartPopup).getText(), "Ürün sepete eklendi");

		extentTest.log(LogStatus.PASS, "add to cart message seen");
		TestResult.add("CheckedAddCartMessage case successfully done");
		EndReport("CheckedAddCartMessage case successfully done");
	}
	
	@Test(priority = 14)
	public void GoToMyCartPage() {
		StartReport("GoToMyCartPage case is failed");
		//go myCart page and myCart page checked
		WaitVisibil(By.xpath("//span[contains(text(),'Sepetim')]"));
		Click(By.xpath("//span[contains(text(),'Sepetim')]"));
		
		WebElement myCart = driver.findElement(By.xpath("//h1[normalize-space()='Sepetim']"));
		WaitVisibil(By.xpath("//h1[normalize-space()='Sepetim']"));
		Assert.assertEquals(myCart.getText(), "Sepetim");

		extentTest.log(LogStatus.PASS, "go to myCart page");
		TestResult.add("GoToMyCartPage case successfully done");
		EndReport("GoToMyCartPage case successfully done");
	}
	
	@Test(priority = 15)
	public void RemoveProductFromMyCart(){
		StartReport("RemoveProductFromMyCart case is failed");
		//product remove from myCart
		
		WebElement addedProduct = driver.findElement(By.id("onboarding_item_list")).findElement(By.xpath("//ul/li"));
		Actions action = new Actions(driver);
		action.moveToElement(addedProduct).perform();
		
		WaitVisibil(By.xpath("//ul/li[1]/div/div/div[2]/div[4]/div[2]/div/a[2]"));
		WebElement deleteBtn = driver.findElement(By.xpath("//ul/li[1]/div/div/div[2]/div[4]/div[2]/div/a[2]"));
		deleteBtn.click();
		
		WaitVisibil(By.xpath("//ul/li[1]/div/div/div[2]/div[4]/div[2]/div[2]/div/div/div/button[2]"));
		WebElement secondDeleteBtn = driver.findElement(By.xpath("//ul/li[1]/div/div/div[2]/div[4]/div[2]/div[2]/div/div/div/button[2]"));
		secondDeleteBtn.click();
		
		extentTest.log(LogStatus.PASS, "Product remove from myCart");
		TestResult.add("RemoveProductFromMyCart case successfully done");
		EndReport("RemoveProductFromMyCart case successfully done");
	}
	
	@Test(priority = 16)
	public void CheckedProductRemoveMessage() {
		StartReport("CheckedProductRemoveMessage case is failed");
		//checked that the product has been deleted
		WebElement deleteMessage = driver.findElement(By.xpath("//div/div/div[2]/div/div/div/div[2]/span"));
		Assert.assertEquals(deleteMessage.getText(), "Ürün sepetinizden silinmiştir");

		extentTest.log(LogStatus.PASS, "checked product remove message");
		TestResult.add("CheckedProductRemoveMessage case successfully done");
		EndReport("CheckedProductRemoveMessage case successfully done");
	}
	
	
	public void StartReport(String Message) {
		testResultMessage = Message;
	}
	
	public void EndReport (String Message) {
		isPass = true;
		testResultMessage= Message;
	}
	
}
