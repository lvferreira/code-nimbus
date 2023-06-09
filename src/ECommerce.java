import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ECommerce {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// Launch Browser (webdriver.browser.driver -> path)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		driver.get(url);

		addItems(driver);
		applyPromo(driver);
		validCode(driver);
		takeScreenshot(driver);
		
		driver.quit();
	}

	public static void addItems(WebDriver driver) throws InterruptedException {
		String[] items = { "Brocolli", "Cucumber", "Tomato" };

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String item = products.get(i).getText();
			String[] temp = item.split("-");
			String name = temp[0].trim();
			System.out.println(name);

			// Convert array into arrayList for optimized search
			// Check whether extracted name is present in arrayList or not
			List<String> list = Arrays.asList(items);

			if (list.contains(name)) {
				j++;
				// Click on Add To Cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // button[text()='ADD
																										// TO CART']
				if (j == list.size()) {
					break;
				}
			}
		}
		Thread.sleep(1000L);
		driver.findElement(By.className("cart-icon")).click();
	}
	
	public static void applyPromo(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
	}
	
	public static void validCode(WebDriver driver) {
				//	 String promoInfo = driver.findElement(By.cssSelector("span.promoInfo")).getText();
				//		System.out.println(promoInfo);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement promoInfo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.promoInfo")));
		Assert.assertEquals(promoInfo.getText(), "Code applied ..!");
			System.out.println(promoInfo.getText());
	}

	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}

}
