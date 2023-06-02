import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class Index {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Invoking Browser
		// 
		// Chrome - ChromeDriver (chromedriver.exe) -> Chrome Browser (methods)
		// Firefox - FirefoxDriver (geckodriver.exe) -> Methods
		// Edge - EdgeDriver (edgedriver.exe) -> Methods
		
		// WebDriver Interface + Browser Driver Class Methods
		String webdriver = "webdriver.edge.driver";
		String path = "C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\msedgedriver.exe";
		System.setProperty(webdriver, path);
		
		// Launch Browser (webdriver.browser.driver -> path)
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		pageElements(driver);
		validPassword(driver);
		//		invalidPassword(driver);
		//		forgotPassword(driver);
		
		driver.close();
		
	}
	
	// Page Elements
		public static void pageElements(WebDriver driver) {
			String url = "https://rahulshettyacademy.com/";
			driver.get(url);
			driver.get(url+"locatorspractice/");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
		}
			
	
	// Valid password
		public static void validPassword(WebDriver driver) {
		driver.findElement(By.id("inputUsername")).sendKeys("lahunkbal");; //#inputUsername
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");; //inputPassword
		driver.findElement(By.className("signInBtn")).click(); //.signInBtn
		//		Thread.sleep(1000);
			
		// Declare an explicit wait with a timeout of 10 seconds
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
		// Wait for the element to be visible before interacting with it
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"You are successfully logged in.\"]")));
	        
	    String loginMessage = element.getText();
	    Assert.assertEquals(loginMessage, "You are successfully logged in.");
	    //		String loginMessage = driver.findElement(By.tagName("p")).getText();
		//		Assert.assertEquals(loginMessage, "You are successfully logged in.");
				System.out.println(loginMessage);
	}
		
	// Invalid password
		public static void invalidPassword(WebDriver driver) {
			driver.findElement(By.id("inputUsername")).sendKeys("lahunkbal"); //#inputUsername
			driver.findElement(By.name("inputPassword")).sendKeys("rahulshettacademy");//inputPassword 
			driver.findElement(By.className("signInBtn")).click(); //.signInBtn
			String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
			System.out.println(errorMessage); //errorMessage
		}
			  
	// Forgot password
		public static void forgotPassword(WebDriver driver) {
			driver.findElement(By.linkText("Forgot your password?")).click();
			driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).
			sendKeys("Lahun Akbal");
			driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("lahunakbal@mail.io");
			driver.findElement(By.xpath("//input[@placeholder=\"Phone Number\"]")).sendKeys("(11)94785-2674");
			driver.findElement(By.cssSelector("button.reset-pwd-btn")).click(); String
			infoMsg = driver.findElement(By.className("infoMsg")).getText(); //.infoMsg
			System.out.println(infoMsg);
		}

}
