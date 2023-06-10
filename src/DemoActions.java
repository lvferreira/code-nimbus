import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://www.amazon.com/";
		driver.get(url);
		
		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));

		Actions action = new Actions(driver);
		action.moveToElement(accountList).build().perform();
		action.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("hello kitty").build().perform();
		action.moveToElement(searchButton).click().build().perform();	
	}

}
