import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Frames {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// Launch Browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

				String url = "https://jqueryui.com/droppable/";
				driver.get(url);
				
				driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
				driver.findElement(By.id("draggable")).isDisplayed();
				
				Actions action = new Actions(driver);
				WebElement source = driver.findElement(By.cssSelector("#draggable"));
				WebElement target = driver.findElement(By.cssSelector("#droppable"));
				action.dragAndDrop(source, target).build().perform();
				
				takeScreenshot(driver);
				driver.switchTo().defaultContent();
				driver.quit();
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}

}
