import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WindowHandler {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/loginpagePractise/#";
		driver.get(url);

		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		Iterator<String> itr = windows.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);

		String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(text);

		String email = emailExtractor(text);
		System.out.println(email);
		
		int atIndex = email.lastIndexOf("@");
		int dotIndex = email.lastIndexOf(".");
		String username = email.substring(atIndex + 1, dotIndex);
		String password = "learning";

		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);

		boolean isSelected = driver.findElement(By.cssSelector("input[value='admin']")).isSelected();
		if (isSelected == true) {
			System.out.println("Admin is Selected: " + isSelected);
		} else {
			System.out.println(isSelected);
		}
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Admin']"));
		String radioText = element.getText();
		Assert.assertEquals(radioText, "Admin");

		WebElement userPersona = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select select = new Select(userPersona);
		select.selectByValue("teach");

		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();

		takeScreenshot(driver);
		driver.quit();
	}

	public static String emailExtractor(String text) {
		// Define the pattern for matching email addresses
		String pattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";

		// Create a Pattern object with the pattern
		Pattern emailPattern = Pattern.compile(pattern);

		// Create a Matcher object and apply the pattern to the input text
		Matcher matcher = emailPattern.matcher(text);

		// Find the email address in the text
		if (matcher.find()) {
			String emailAddress = matcher.group();
			System.out.println("Email Address: " + emailAddress);
			
			return emailAddress;
		} else {
			System.out.println("No email address found in the text.");
		}
		return null;
	}

	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}

}
