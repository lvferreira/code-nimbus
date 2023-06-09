import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClickJet {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);

		// Dropdowns
		// Click static currency dropdown
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		driver.findElement(By.id("divpaxinfo")).click();
		// WebElement element =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divpaxOptions")));
		Thread.sleep(1000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 0;
		while (i < 5 - 1) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		String paxInfo = driver.findElement(By.id("divpaxinfo")).getText();
		Assert.assertEquals(paxInfo, "5 Adult");
		System.out.println(paxInfo);

		// Click dynamic origin/destination dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click(); // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}

		}

		// Checkboxes
		boolean elementIsSelectedFalse = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"))
				.isSelected();
		Assert.assertFalse(elementIsSelectedFalse);
		System.out.println(elementIsSelectedFalse);

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		boolean elementIsSelectedTrue = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"))
				.isSelected();
		Assert.assertTrue(elementIsSelectedTrue);
		System.out.println(elementIsSelectedTrue);

		// Counting the number of checkboxes
		int chkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(chkBoxes);

		// Radio Button
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		if (driver.findElement(By.className("picker-second")).getAttribute("style").contains("opacity: 1")) {
			System.out.println("it's enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// Search Flight
		// driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.cssSelector("input[value='Search']")).click();

		takeScreenshot(driver);
		driver.quit();

	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}

}
