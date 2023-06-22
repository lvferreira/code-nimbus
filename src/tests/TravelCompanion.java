package tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TravelCompanion {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://www.path2usa.com/travel-companion/";
		driver.get(url);
		Thread.sleep(5000L);
		scrollDown(driver);
		
		// Perform the click action
		WebElement datePicker = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		datePicker.click();
		
		LocalDate currentDate = LocalDate.now();
		String fullMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		WebElement month = driver.findElement(By.xpath("//span[@class='cur-month']"));
		String text = month.getText().trim();
		// String year = driver.findElement(By.xpath("//input[contains(@class, 'cur-year')]")).getText().trim();
			System.out.println(month);
			// System.out.println(year);
		boolean currentMonth = text.contains(fullMonth);
		// boolean currentYear = year.contains("2023");
			System.out.println(currentMonth);
			// System.out.println(currentYear);		
			while(currentMonth) {
				driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
					Thread.sleep(1000L);
				text = month.getText().trim();
				currentMonth = text.contains(fullMonth);
					System.out.println(text);
					System.out.println(currentMonth);
				//	break;
			}

		List<WebElement> days = driver.findElements(By.xpath("//span[contains(@class, 'flatpickr-day')]"));
			for (int i = 0; i < days.size(); i++) {
				String day = days.get(i).getText();
				if (day.equalsIgnoreCase("12")) {
					days.get(i).click();
					break;
				}
			}
		takeScreenshot(driver);
		driver.quit();
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}
	
	public static void scrollDown(WebDriver driver) throws InterruptedException {
		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to the element
		js.executeScript("window.scrollBy(0,1000)");
			//	js.executeScript("arguments[0].scrollIntoView(true);", datePicker);
			Thread.sleep(5000L);
	}

}
