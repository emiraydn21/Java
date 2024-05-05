package org.example.seturotomasyon;

import org.example.pages.HomePage;
import org.example.pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class SeturTest {
    private WebDriver driver;
    private HomePage homePage;

    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        // Popup'ları engelle
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        // Tarayıcı penceresini tam ekran yapma
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);

    }

    @Test
    public void testAntalyaSearch() throws IOException {
        homePage.navigateToSetur();
        homePage.verifyPageUrl();
        homePage.handlePopups(); // Pop-up engelleme metodu (HomePage sınıfına ekleyin)
        homePage.verifyHotelTabIsDefault(); // Otel sekmesi kontrolü
        homePage.enterDestinationAndSelectAntalyaFromCsv("C:\\Users\\emira\\Documents\\IntellijIdeaProjects\\setur-otomasyon\\test.csv");
        homePage.clickDatePicker();
        homePage.clickAdultCount();
        homePage.incrementAdultCount();
        homePage.verifyAdultCountIncreased();
        homePage.clickSearchButtonIfVisible();
        searchResultsPage.verifyUrlContainsAntalya();

        // ... diğer test adımları
    }

    @After
    public void tearDown() {
       // driver.quit();
    }
}
