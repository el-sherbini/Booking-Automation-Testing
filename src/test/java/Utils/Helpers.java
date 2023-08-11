package Utils;

import Pages.ResultsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public static void javaScriptExecutor(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("An error occurred while clicking the element: " + e.getMessage());
        }
    }

    public static void selectOptionFromDropdown(WebElement dropdownElement, String optionValue) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(optionValue);
    }

    public static void checkHotelAvailability(WebDriver driver, ResultsPage resultsPage, String hotelTitle) {
        while (resultsPage.getLastPageNumTxt() != resultsPage.getNextPageBtnTxt() + 1) {
            boolean flag = false;
            List<WebElement> allHotelTitles = resultsPage.getHotelTitleElements();
            for (WebElement hotelTitleElement : allHotelTitles) {
                if (hotelTitleElement.getText().contains(hotelTitle)) {
                    resultsPage.clickHotelSeeAvailabilityBtn();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                javaScriptExecutor(driver, resultsPage.getNextPageBtn());
                driver.navigate().refresh();
            } else {
                break;
            }
        }
    }

    @DataProvider(name = "reservationData")
    public static Iterator<Object[]> getReservationData() {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("src/test/java/Resources/TestData.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String searchText = row.getCell(0).getStringCellValue();
                String checkInDate = row.getCell(1).getStringCellValue();
                String checkOutDate = row.getCell(2).getStringCellValue();

                data.add(new Object[]{searchText, checkInDate, checkOutDate});
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.iterator();
    }
}
