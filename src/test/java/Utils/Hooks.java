package Utils;

import Pages.ConfirmationPage;
import Pages.DetailsPage;
import Pages.HomePage;
import Pages.ResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {
    public static WebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;
    protected DetailsPage detailsPage;
    protected ConfirmationPage confirmationPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        detailsPage = new DetailsPage(driver);
        confirmationPage = new ConfirmationPage(driver);

        homePage.openURL(TestConfig.BASE_URL);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
