import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodeSnippet {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Test Case 1: Open the website and perform actions
        openWebsite(driver);
        performActions(driver);

        // Test Case 2: Verify elements on the page
        openWebsite(driver);
        verifyElements(driver);

        // Close the browser
        driver.quit();
    }

    public static void openWebsite(WebDriver driver) {
        // Navigate to the desired web page
        driver.get("https://www.example.com");
    }

    public static void performActions(WebDriver driver) {
        // Find elements and perform actions
        WebElement element = driver.findElement(By.id("exampleId"));
        element.click();
    }

    public static void verifyElements(WebDriver driver) {
        // Verify elements on the page
        WebElement element = driver.findElement(By.id("exampleId"));
        boolean isDisplayed = element.isDisplayed();
        System.out.println("Element is displayed: " + isDisplayed);
    }
}