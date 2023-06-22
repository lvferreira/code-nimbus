import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/seleniumPractise/#";
		driver.get(url);

		addItems(driver);
		applyPromo(driver);
		validCode(driver);
		topDeals(driver, url);
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
		// String promoInfo =
		// driver.findElement(By.cssSelector("span.promoInfo")).getText();
		// System.out.println(promoInfo);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement promoInfo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.promoInfo")));
		Assert.assertEquals(promoInfo.getText(), "Code applied ..!");
		System.out.println(promoInfo.getText());
	}

	public static void topDeals(WebDriver driver, String url) {
		driver.navigate().to(url + "offers");
		// driver.findElement(By.cssSelector(".cart-header-navlink[href='#/offers']")).click();
		// click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		// capture all webelements into list
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		// capture text of all webelements into new list(original)
		List<String> list = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort original list step 3 -> sorted list
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
		// compare original list vs sorted list
		Assert.assertTrue(list.equals(sortedList));
		List<String> price;
		// scan name column getText -> Beans -> print price
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s))
					.collect(Collectors.toList());
			price.forEach(e -> System.out.println(e));
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		// enter text on search field
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Banana");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText()
				.contains("Banana"))
				.collect(Collectors.toList());
		Assert.assertEquals(veggies, filteredList);
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return value;
	}

	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}

}
