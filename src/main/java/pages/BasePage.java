package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    public static void closeBrowser() {
        driver.quit();
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private static WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private static List<WebElement> findAll(String locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
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

    public static String getValueFromTable(String locator, int row, int col) {
        String cell = locator + "/table/tbody/tr[" + row + "]/td[" + col + "]";
        return find(cell).getText();
    }

    public static void setValueOnTable(String locator, int row, int col, String text) {
        String cell = locator + "/table/tbody/tr[" + row + "]/td[" + col + "]";
        find(cell).sendKeys(text);
    }

    public String getTextFromElement(String locator) {
        return find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    public void switchToIFrameByIndex(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public List<String> getTextFromWebElementList(String locator) {
        List<WebElement> list = findAll(locator);
        List<String> stringList = new ArrayList<>();

        for (WebElement e : list) {
            stringList.add(e.getText());
        }
        return stringList;
    }
}
