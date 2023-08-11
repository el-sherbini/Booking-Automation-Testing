package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By searchTxtBox = By.xpath("//input[@id=\":rc:\" or @placeholder=\"Where are you going?\"]");
    private By checkInBtn = By.xpath("//button[@data-testid=\"date-display-field-start\"]");
    private By checkOutBtn = By.xpath("//button[@data-testid=\"date-display-field-end\"]");
    private By calendarNextBtn = By.xpath("//div[@id=\"calendar-searchboxdatepicker\"]//span[@class=\"b6dc9a9e69 e6c50852bd\"]");
    private By calendarMonthTitle = By.xpath("(//h3[@aria-live=\"polite\"])[2]");
    private By searchBtn = By.xpath("//button[@type=\"submit\"]//span[text()=\"Search\"]");

    public void setSearchTxt(String searchText) {
        sendKeysToElement(searchTxtBox, searchText);
    }

    public WebElement getCheckInBtn() { return findElement(checkInBtn); }

    public String getCheckOutBtnTxt() { return getTextFromElement(checkOutBtn); }

    public WebElement getCalendarNextBtn() { return findElement(calendarNextBtn); }

    public String getCalendarMonthTitleTxt() { return getTextFromElement(calendarMonthTitle); }

    public WebElement getCheckInDate(String date) { return findElement(By.xpath("//span[@data-date='" + date + "']")); }

    public WebElement getCheckOutDate(String date) { return findElement(By.xpath("//span[@data-date='" + date + "']")); }

    public WebElement getSearchBtn() {
        return findElement(searchBtn);
    }
}
