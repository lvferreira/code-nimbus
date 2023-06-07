import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Invoking Browser
		// 
		// Chrome - ChromeDriver (chromedriver.exe) -> Chrome Browser (methods)
		// Firefox - FirefoxDriver (geckodriver.exe) -> Firefox Browser (methods)
		// Edge - EdgeDriver (edgedriver.exe) -> Edge Browser (methods)
		
		// WebDriver Interface + Browser Driver Class Methods
		String webdriver = "webdriver.chrome.driver";
		String path = "C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\chromedriver.exe";
			System.setProperty(webdriver, path);
		
		// Launch Browser (webdriver.browser.driver -> path)
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		pageElements(driver);
		validPassword(driver);
		//	invalidPassword(driver);
		//	forgotPassword(driver);
		
		driver.close();
		
	}
	
	// Page elements
		public static void pageElements(WebDriver driver) {
			String url = "https://rahulshettyacademy.com/";
			driver.get(url+"locatorspractice/");
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
		}	
	
	// Valid password
		public static void validPassword(WebDriver driver) throws InterruptedException {
			// Declare an explicit wait with a timeout of 10 seconds
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    
			String username = "lahunakbal";
			String password = forgotPassword(driver);
			
			driver.findElement(By.cssSelector(".go-to-login-btn")).click();
			
			driver.findElement(By.id("inputUsername")).sendKeys(username);; //#inputUsername
			driver.findElement(By.name("inputPassword")).sendKeys(password);; //inputPassword
			//	driver.findElement(By.className("signInBtn")).click(); //.signInBtn
			
			// Wait for the button to be clickable
			WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("signInBtn")));
			// Click the button
			signInBtn.click();
			
			// Wait for the element to be visible before interacting with it
		    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"You are successfully logged in.\"]")));
		    String loginMessage = element.getText();
		    Assert.assertEquals(loginMessage, "You are successfully logged in.");
		    	//	String loginMessage = driver.findElement(By.tagName("p")).getText();
				//	Assert.assertEquals(loginMessage, "You are successfully logged in.");
		    	System.out.println(loginMessage);
		    	
		    Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+username+",");
			driver.findElement(By.xpath("//*[text()='Log Out']")).click();
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
		public static String forgotPassword(WebDriver driver) {
			driver.findElement(By.linkText("Forgot your password?")).click();
			driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("Lahun Akbal");
			driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("lahunakbal@mail.io");
			driver.findElement(By.xpath("//input[@placeholder=\"Phone Number\"]")).sendKeys("(11)94785-2674");
			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			String infoMsg = driver.findElement(By.className("infoMsg")).getText(); //.infoMsg
				System.out.println(infoMsg);
			// Please use temporary password 'rahulshettyacademy' to Login.
			Pattern pattern = Pattern.compile("'(.*?)'");
		    Matcher matcher = pattern.matcher(infoMsg);
		        if (matcher.find()) {
		            String passWord = matcher.group(1);
						System.out.println(passWord);
		            return passWord;
		        }		    
		    return null;
		}

}
