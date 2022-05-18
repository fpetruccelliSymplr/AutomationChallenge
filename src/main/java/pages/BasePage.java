package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private static WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void clickElement(String locator) {
        find(locator).click();
    }

    public static void sendText(String locator, String text) {
        find(locator).sendKeys(text);
    }

    public static void selectFromDropdownByText(String locator, String text) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(text);
    }

    public static void hoverOverElement(String locator) {
        actions.moveToElement(find(locator));
    }

    public static void doubleClickOnElement(String locator) {
        actions.doubleClick(find(locator));
    }

    public static void contextClick(String locator) {
        actions.contextClick(find(locator));
    }
}
