package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks  {

	public static void main(String[] args) throws MalformedURLException, IOException {

		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		// Broken URL
		// Step 1 - Is to get all urls tied up to the links using Selenium
		// Java methods will call URL's and gets you the status code
		// if status code > 400 then that url is not working-> link which tied to url is broken
		// a[href*="soapui"]'
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert a = new SoftAssert();

		for (WebElement link : links)

		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);

			a.assertTrue(statusCode < 400, "The link with Text" + link.getText() + " is broken with code" + statusCode);
		}
		a.assertAll();
	}

}