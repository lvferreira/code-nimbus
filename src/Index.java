import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//		String webdriver = "webdriver.chrome.driver";
		//		String path = "C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\chromedriver.exe";
		//			System.setProperty(webdriver, path);
		
		// Launch Browser (webdriver.browser.driver -> path)
			WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
			String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		driver.findElement(By.cssSelector("[placeholder='Enter Your Name']")).sendKeys("Lahun Akbal");
		driver.findElement(By.cssSelector("[onclick='displayAlert()']")).click();
		
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		driver.close();
	}

}
