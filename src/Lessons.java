import java.io.File;
import java.io.IOException;
//	import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//	import org.openqa.selenium.support.ui.ExpectedConditions;
//	import org.openqa.selenium.support.ui.WebDriverWait;
//	import org.openqa.selenium.support.ui.Select;
//	import org.testng.Assert;

public class Lessons {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// Launch Browser
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/AutomationPractice/#";
		driver.get(url);

		// Previous Assignments
		// Click on a given Checkbox element
		WebElement checkBox = driver.findElement(By.cssSelector("#checkBoxOption2"));
		checkBox.click();

		boolean elementIsSelectedTrue = checkBox.isSelected();
		Assert.assertTrue(elementIsSelectedTrue);
		System.out.println(elementIsSelectedTrue);

		WebElement parentBox = checkBox.findElement(By.xpath("./.."));
		String textBox = parentBox.getText().trim();
		System.out.println(textBox);

		// Select dropdown by visible text extracted from previous element
		//
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select options = new Select(dropDown);
		options.selectByVisibleText(textBox);
		// Enter text on input type field
		// Matches text extracted from previous element on alert message
		driver.findElement(By.cssSelector("#name")).sendKeys(textBox);
		driver.findElement(By.cssSelector("[onclick='displayAlert()']")).click();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		boolean matchText = alertMessage.contains(textBox);
		System.out.println(matchText);
		driver.switchTo().alert().accept();

		// Row Count Table Assignment
		WebElement tableElement = driver.findElement(By.id("product"));
		scrollDown(driver);
		// Get all the rows in the table
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		// Get the number of rows
		int rowCount = rows.size();
		// Get the first row to determine the number of columns
		WebElement firstRow = rows.get(0);
		List<WebElement> columns = firstRow.findElements(By.tagName("th"));
		// Get the number of columns
		int columnCount = columns.size();
		// Print the number of rows and columns
		System.out.println("Number of rows: " + rowCount);
		System.out.println("Number of columns: " + columnCount);

		// Get the second row
		WebElement secondRow = rows.get(2);
		// Get the columns in the second row
		List<WebElement> rowColumns = secondRow.findElements(By.tagName("td"));
		// Print the values of each column in the second row
		for (WebElement column : rowColumns) {
			System.out.println(column.getText());
		}

		// AutoComplete DropDown Assignment
		// Locate the "Suggession Class Example" WebElement
		WebElement suggestionExample = driver.findElement(By.id("select-class-example"));
		// Find the input field within the "Suggession Class Example" section
		WebElement inputField = suggestionExample.findElement(By.id("autocomplete"));
		// Enter text in the input field
		inputField.sendKeys("unit");
		Thread.sleep(3000);
		// Verify if the expected value is present in the suggestion dropdown
		// Click on element if present
		String expectedValue = "United States (USA)";
		List<WebElement> suggestedOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		for (WebElement option : suggestedOptions) {
			boolean isValuePresent = option.getText().equalsIgnoreCase(expectedValue);
			if (isValuePresent) {
				System.out.println("Selected value: " + option.getText());
				option.click();
				//
				break;
			} else {
				System.out.println("Expected value not found in the suggestion dropdown.");
			}

		}

		takeScreenshot(driver);
		driver.quit();
	}

	public static void scrollDown(WebDriver driver) throws InterruptedException {
		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to the element
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		// js.executeScript("arguments[0].scrollIntoView(true);", tableElement);
	}

	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}
}
