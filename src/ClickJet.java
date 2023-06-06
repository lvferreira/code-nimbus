import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClickJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Launch Browser (
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
				//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
			String url = "https://rahulshettyacademy.com/dropdownsPractise/";
			driver.get(url);
			
			// Dropdowns
			// Click static currency dropdown
			WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByIndex(3);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByVisibleText("AED");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByValue("INR");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			
			driver.findElement(By.id("divpaxinfo")).click();
				//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divpaxOptions")));
			Thread.sleep(1001L);
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			int i=0;
		while(i<5-1)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
			driver.findElement(By.id("btnclosepaxoption")).click();
			String paxInfo = driver.findElement(By.id("divpaxinfo")).getText();
			Assert.assertEquals(paxInfo, "5 Adult");
			System.out.println(paxInfo);
			
			// Click dynamic origin/destination dropdowns
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			Thread.sleep(1001L);
				// 		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click(); // ctl00_mainContent_ddl_destinationStation1_CTXT
				//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

				//		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
			
			driver.findElement(By.id("autosuggest")).sendKeys("ind");
			List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
			for(WebElement option :options)
			{
				if(option.getText().equalsIgnoreCase("India"))
				{
					option.click();
					break;
				}
				
			}
			
			// Checkboxes
			boolean elementIsSelectedFalse = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
			Assert.assertFalse(elementIsSelectedFalse);	
				System.out.println(elementIsSelectedFalse);
				
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			
			boolean elementIsSelectedTrue = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
			Assert.assertTrue(elementIsSelectedTrue);
				System.out.println(elementIsSelectedTrue);
				
			// Counting the number of checkboxes
			int chkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
			System.out.println(chkBoxes);
				
			driver.quit();
			
	}

}
