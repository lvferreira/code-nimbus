import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Index {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// String webdriver = "webdriver.chrome.driver";
		// String path =
		// "C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\chromedriver.exe";
		// System.setProperty(webdriver, path);

		// Launch Browser (webdriver.browser.driver -> path)
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);

		// Alert/Confirm Browser Message
		driver.findElement(By.cssSelector("[placeholder='Enter Your Name']")).sendKeys("Lahun Akbal");
		driver.findElement(By.cssSelector("[onclick='displayAlert()']")).click();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();

		driver.findElement(By.cssSelector("[placeholder='Enter Your Name']")).sendKeys("Lahun Akbal");
		driver.findElement(By.cssSelector("[onclick='displayConfirm()']")).click();

		String confirmMessage = driver.switchTo().alert().getText();
		System.out.println(confirmMessage);
		driver.switchTo().alert().dismiss();
		// WebElement tableElement = driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']"));
		scrollDown(driver);

		int sum = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for (int i = 0; i < values.size(); i++) {
			System.out.println(Integer.parseInt(values.get(i).getText()));
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println("The total sum is " + sum);
		String total = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		Assert.assertEquals(sum, Integer.parseInt(total));

		driver.close();
	}

	public static void scrollDown(WebDriver driver) throws InterruptedException {
		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to the element
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
			// js.executeScript("arguments[0].scrollIntoView(true);", datePicker);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
			// js.executeScript(String.format("document.querySelector('%d').scrollTop=5000"), tableElement);
			// js.executeScript("arguments[0].scrollTop=5000", tableElement);
	}

}
