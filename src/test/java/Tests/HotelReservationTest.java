package Tests;

import Utils.Helpers;
import Utils.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utils.Helpers.*;

public class HotelReservationTest extends Hooks {
    private static final String HOTEL_NAME_TO_RESERVE = "Tolip Hotel Alexandria";
    private static String checkInDateTxt, checkOutDateTxt, expectedHotelName;

    @Test(dataProvider = "reservationData", dataProviderClass = Helpers.class)
    public void searchForHotelAndVerifyResults(String searchText, String checkInDate, String checkOutDate){
        homePage.setSearchTxt(searchText);

        javaScriptExecutor(driver, homePage.getCheckInBtn());
        while (!homePage.getCalendarMonthTitleTxt().contains("October")) {
            javaScriptExecutor(driver, homePage.getCalendarNextBtn());
        }
        javaScriptExecutor(driver, homePage.getCheckInDate(checkInDate));
        javaScriptExecutor(driver, homePage.getCheckOutDate(checkOutDate));

        checkInDateTxt = homePage.getCheckInBtn().getText();
        checkOutDateTxt = homePage.getCheckOutBtnTxt();

        javaScriptExecutor(driver, homePage.getSearchBtn());

        Assert.assertTrue(resultsPage.getResultsTitleTxt().contains(searchText), "Search Title assertion failed");
    }

    @Test (dependsOnMethods = "searchForHotelAndVerifyResults")
    public void selectHotelAndVerifyDetails(){
        // First idea is by filtering with "Hotels" only (Uncomment this line to check)
        //  resultsPage.clickHotelsFilterBtn();

        // For the main idea I create this function to check if the current page contains the hotel card or not
        // if it has will click it and if not will click on the next page button
        checkHotelAvailability(driver, resultsPage, HOTEL_NAME_TO_RESERVE);

        Assert.assertEquals(detailsPage.getAvailabilityCheckInDateTxt(), checkInDateTxt, "Check In Date assertion failed");
        Assert.assertEquals(detailsPage.getAvailabilityCheckOutDateTxt(), checkOutDateTxt, "Check Out Date assertion failed");
    }

    @Test (dependsOnMethods = "selectHotelAndVerifyDetails")
    public void reserveSelectedHotelAndVerifyConfirmation() {
        expectedHotelName = detailsPage.getHotelNameTxt();
        detailsPage.clickBedRadioBtn();
        selectOptionFromDropdown(detailsPage.getRoomsAmountDropdown(), "1");
        detailsPage.clickReserveBtn();

        Assert.assertEquals(expectedHotelName, confirmationPage.getConfirmationHotelName(), "Assertion for Hotel Name failed");
        Assert.assertTrue(confirmationPage.getConfirmationCheckInDate().contains(checkInDateTxt), "Check In Date assertion failed");
        Assert.assertTrue(confirmationPage.getConfirmationCheckOutDate().contains(checkOutDateTxt), "Check Out Date assertion failed");
    }
}
