import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// WebDriver Interface + Browser Driver Class Methods
		//		String webdriver = "webdriver.chrome.driver";
		//		String path = "C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\chromedriver.exe";
		//			System.setProperty(webdriver, path);
						
		// Launch Browser (webdriver.browser.driver -> path)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://google.com/";
		driver.get(url);
		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.quit();
	}

}
