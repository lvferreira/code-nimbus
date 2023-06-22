package tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://the-internet.herokuapp.com/nested_frames";
		driver.get(url);
		
		// Switch to the 'frame-middle' frame
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");

		// Locate the element with id 'content' and retrieve its text
		WebElement element = driver.findElement(By.id("content"));
		String text = element.getText();
		System.out.println(text);
		
		driver.quit();
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\CodeNimbus\\out\\screenshot.png"));
		Thread.sleep(1000L);
	}

}
