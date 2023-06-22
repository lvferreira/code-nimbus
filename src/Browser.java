import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;

public class Browser {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// FirefoxOptions options = new FirefoxOptions();
		// options.setAcceptInsecureCerts(true);

		// EdgeOptions options = new EdgeOptions();
		// options.setAcceptInsecureCerts(true);

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		Proxy proxy = new Proxy();
		proxy.setHttpProxy("127.0.0.1:8080");

		options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);

		// WebDriver Interface + Browser Driver Class Methods
		// String webdriver = "webdriver.chrome.driver";
		// String path = "C:\\Users\\Leandro\\Eclipse-Workspace\\SeleniumWebdriver\\chromedriver.exe";
		// System.setProperty(webdriver, path);
		
		// Launch Browser (webdriver.browser.driver -> path)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().deleteCookieNamed("session");
		driver.manage();

		String url = "https://google.com/";
		driver.get(url);
		driver.navigate().to("//https://expired.badssl.com/"); // https://rahulshettyacademy.com/
		driver.navigate().back();
		driver.navigate().forward();
			System.out.println(driver.getTitle());

		takeScreenshot(driver);
		driver.quit();
	}

	public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {
		String userDir = System.getProperty("user.dir");
		String path = String.format("%s\\out\\screenshot.png", userDir);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(path));
			Thread.sleep(1000L);
	}

}
