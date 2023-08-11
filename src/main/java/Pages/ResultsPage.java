package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private By resultsTitle = By.xpath("//h1[@aria-live='assertive']");
    private By hotelSeeAvailabilityBtn = By.xpath("//div[contains(text(), 'Tolip Hotel Alexandria')]/ancestor::div[contains(@class, 'd20f4628d0')]//a[@data-testid='availability-cta-btn']");
    private By hotelsFilterBtn = By.xpath("//div[@data-filters-group='ht_id']//div[@data-testid='filters-group-label-content' and text()='Hotels']");
    private By hotelTitleEle = By.xpath("//div[@data-testid=\"title\"]");
    private By nextPageBtn = By.xpath("(//li[button[@aria-current=\"page\"]]//following-sibling::li//button)[1]");
    private By lastPageNumTxt = By.xpath("(//button[@class=\"a83ed08757 a2028338ea\"])[last()]");

    public String getResultsTitleTxt() {
        return getTextFromElement(resultsTitle);
    }

    public void clickHotelSeeAvailabilityBtn() {
        clickElement(hotelSeeAvailabilityBtn);
    }

    public void clickHotelsFilterBtn() {
        clickElement(hotelsFilterBtn);
    }

    public List<WebElement> getHotelTitleElements() { return findElements(hotelTitleEle);}

    public WebElement getNextPageBtn() { return findElement(nextPageBtn);}

    public String getNextPageBtnTxt() { return getTextFromElement(nextPageBtn);}

    public String getLastPageNumTxt() { return getTextFromElement(lastPageNumTxt);}
}
