package Automation;



import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class MyTestCases extends MyData{

	
	WebDriver driver = new EdgeDriver(); 
	
	String MyWebSite = "https://automationteststore.com/";
	
	String SignUpPage = "https://automationteststore.com/index.php?rt=account/create";
	
	
	@BeforeTest
	public void MySetup() {
		driver.get(MyWebSite);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        
        
	}
	
	
	@Test(priority = 1, enabled = false)
	public void SignUpTest() throws InterruptedException {
		
		driver.navigate().to(SignUpPage);
		
		WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		WebElement Telephone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement TheFax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement Thecountry = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));
		
		Select mySelectElementForcountry = new Select(Thecountry); 
		Select mySelectElementForState = new Select(TheState); 

		
		mySelectElementForcountry.selectByIndex(108);
		Thread.sleep(2000);
		mySelectElementForState.selectByIndex(TheSelectStateIndex);

		List <WebElement> AllTheState = TheState.findElements(By.tagName("option"));
		String TheCity = AllTheState.get(TheSelectStateIndex).getText();
		
		WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement TheLoginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));
        WebElement AgreeCheck = driver.findElement(By.id("AccountFrm_agree"));
        WebElement CountinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
       
		FirstName.sendKeys(TheFirstName);
		LastName.sendKeys(TheLastName);
		Email.sendKeys(TheEmail);
		Telephone.sendKeys(TelePhone);
		TheFax.sendKeys(TheFaxNumber);
		AddressOne.sendKeys(TheAddressOne);
		TheCityInput.sendKeys(TheCity);
		ThePostalCode.sendKeys(PostalCode);
		TheLoginName.sendKeys(LoginName);
		ThePassword.sendKeys(Password);
		TheConfirmPassword.sendKeys(Password);
		AgreeCheck.click();
		CountinueButton.click();
		Thread.sleep(5000);
		String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();

		// test case ( بتقارن القيمة الحقيقة بالمتوقعة وبتشتغل زي ال if )
		Assert.assertEquals(ActualSignUpMessage, ExpectedTextForTheSignUp);
		
	}
	
	@Test(priority = 2, enabled = false)
	public void LogOut() {
		
		driver.findElement(By.linkText("Logoff")).click();
		
		Boolean ActualValueForLogOut = driver.getPageSource().contains(ExpectedLogOutText);
		Assert.assertEquals(true, ActualValueForLogOut);
		
	}
	
	@Test(priority = 3, enabled = false)
	public void LogInPage() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Login or register']")).click();

		
		WebElement LoginNameinput = driver.findElement(By.id("loginFrm_loginname"));
		WebElement LoginPaswordinput = driver.findElement(By.id("loginFrm_password"));
		
		LoginNameinput.sendKeys(LoginName);
		LoginPaswordinput.sendKeys(Password);
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		LoginButton.click();
		
		
		Boolean ActualValue = driver.getPageSource().contains(WelcomMessage);
		Boolean ExpectedValue = true;
		
		assertEquals(ActualValue, ExpectedValue);

	}
	
	@Test(priority = 4, enabled = true)
	public void AddItemsToTheCart() {
		driver.navigate().to(MyWebSite);
		List<WebElement> AllProductItems = driver.findElements(By.className("prdocutname"));
		int RandomIndexForTheItems = rand.nextInt(AllProductItems.size());
		AllProductItems.get(RandomIndexForTheItems).click();
	}
	
	
	@AfterTest
	public void AfterMyTest() {
		//driver.close();
		//driver.quit();
	}
}
