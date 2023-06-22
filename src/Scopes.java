import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scopes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch Browser
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/AutomationPractice/#";
		driver.get(url);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linksCount = links.size();
			System.out.println("There are "+linksCount+" links on this WebPage");
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		int footerLinks = footer.findElements(By.tagName("a")).size();
			System.out.println("There are "+footerLinks+" links on the Footer");
		
		WebElement discountCoupons = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int couponLinks = discountCoupons.findElements(By.tagName("a")).size();
			System.out.println("There are "+couponLinks+" Discount Coupon links");
		for(int i=1; i<couponLinks; i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			discountCoupons.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			
				Thread.sleep(5000L);
		}
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext()){
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}
