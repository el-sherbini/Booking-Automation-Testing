package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends BasePage{
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    private By availabilityCheckInDate = By.xpath("//div[@data-placeholder='Check-in']");
    private By availabilityCheckOutDate = By.xpath("//div[@data-placeholder='Check-out']");
    private By hotelNameTxt = By.xpath("//h2[contains(@class, \"pp-header__title\")]");
    private By bedRadioBtn = By.xpath("//div[@class='rt-bed-type-select']//input");
    private By roomsAmountDropdown = By.xpath("(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]");
    private By reserveBtn = By.xpath("//button[@type='submit']//span[contains(text(), 'reserve')]");

    public String getAvailabilityCheckInDateTxt() { return getTextFromElement(availabilityCheckInDate); }

    public String getAvailabilityCheckOutDateTxt() {
        return getTextFromElement(availabilityCheckOutDate);
    }

    public String getHotelNameTxt() {
        return getTextFromElement(hotelNameTxt);
    }

    public void clickBedRadioBtn() {
        clickElement(bedRadioBtn);
    }

    public WebElement getRoomsAmountDropdown() { return findElement(roomsAmountDropdown); }

    public void clickReserveBtn() { clickElement(reserveBtn); }
}
