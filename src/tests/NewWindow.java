package tests;

import java.io.File;
import java.io.IOException;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class NewWindow {

	public static void main(String[] args) throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/angularpractice/";
		driver.get(url);

		//Switching Window
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		
		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		driver.switchTo().window(parentWindowId);

		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);

		//Screenshot

		// File file = name.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(file, new File("logo.png"));
		
		takeScreenshot(driver, name);

		//Get Height & Width of a WebElement
		Integer height = name.getRect().getDimension().getHeight();
		Integer width = name.getRect().getDimension().getWidth();
		System.out.println(height);
		System.out.println(width);

		// driver.quit();
	}
	
	public static void takeScreenshot(WebDriver driver, WebElement name) throws IOException, InterruptedException {
		File src = name.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,
				new File("logo.png"));
		Thread.sleep(1000L);
	}

}