package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By confirmationCheckInDate = By.xpath("(//time[contains(@aria-describedby, \"bp-checkin-date__label\")]//span[@class=\"bui-date__title\"])[1]");
    private By confirmationCheckOutDate = By.xpath("(//time[contains(@aria-describedby, \"bp-checkout-date__label\")]//span[@class=\"bui-date__title\"])[1]");
    private By confirmationHotelName = By.xpath("//div[@class=\"bp-mfe-container--property-details\"]//h1");

    public String getConfirmationCheckInDate() { return getTextFromElement(confirmationCheckInDate); }
    public String getConfirmationCheckOutDate() { return getTextFromElement(confirmationCheckOutDate); }
    public String getConfirmationHotelName() { return getTextFromElement(confirmationHotelName); }
}
