package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }

    protected List<WebElement> findElements(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements not found: " + locator, e);
        }
    }

    protected WebElement waitForVisibility(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible: " + locator, e);
        }
    }

    protected void waitForClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not clickable: " + locator, e);
        }
    }

    protected void clickElement(By locator) {
        waitForClickable(locator);
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click element: " + locator, e);
        }
    }

    protected void sendKeysToElement(By locator, String text) {
        waitForVisibility(locator);
        try {
            driver.findElement(locator).sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send keys to element: " + locator, e);
        }
    }

    protected String getTextFromElement(By locator) {
        WebElement element = waitForVisibility(locator);
        return element.getText();
    }

    public void openURL(String url) {
        driver.get(url);
    }
}