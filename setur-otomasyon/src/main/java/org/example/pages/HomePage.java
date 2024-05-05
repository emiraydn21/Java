package org.example.pages;

import org.example.utils.CsvReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HomePage {
        private WebDriver driver;
        private static final String EXPECTED_URL = "https://www.setur.com.tr/";

        // Locator örnekleri
        private By destinationInput = By.id("txtDestination");
        private By searchButton = By.id("btnSearch");

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        public void navigateToSetur() {
            driver.get(EXPECTED_URL);
        }

        public void verifyPageUrl() {
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(EXPECTED_URL)) {
                System.out.println("Sayfa URL'si doğru: " + currentUrl);
            } else {
                System.out.println("Sayfa URL'si yanlış. Beklenen: " + EXPECTED_URL + ", Şu anki: " + currentUrl);
            }
        }


        // ... diğer metotlar

        public void handlePopups() {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                // CybotCookiebotDialog'u kapat
                js.executeScript("var cookieDialog = document.getElementById('CybotCookiebotDialog'); if (cookieDialog) cookieDialog.style.display = 'none';");
                // ins-preview-wrapper'ı kapat
                js.executeScript("var insPreviewWrapper = document.querySelector('div.ins-preview-wrapper.ins-preview-wrapper-598'); if (insPreviewWrapper) insPreviewWrapper.style.display = 'none';");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ins-close-button']")));

                // "X" düğmesine tıkla
                closeButton.click();
            } catch (Exception e) {
                // Popup yoksa veya kapatma işlemi başarısız olduysa devam et
            }
        }
    private By hotelTab = By.xpath("//button[contains(., 'Otel')]");
    private By searchInput = By.cssSelector("input.sc-bde938b1-0.kLxiFo");
    private By searchInputLocator = By.cssSelector("input.sc-bde938b1-0.kLxiFo");


    public void verifyHotelTabIsDefault() {
        try {
            driver.findElement(hotelTab);
            driver.findElement(searchInput).click(); // Arama girişine odaklan
            System.out.println("Otel sekmesi varsayılan olarak yüklenmiş.");
        } catch (NoSuchElementException e) {
            System.out.println("Hata: Otel sekmesi varsayılan olarak yüklenmemiş.");
        }
    }
    public void enterDestinationAndSelectAntalyaFromCsv(String csvFile) throws IOException {
        List<String> destinations = CsvReader.readDataFromCsv(csvFile);

        for (String destination : destinations) {
            driver.findElement(By.cssSelector("input.sc-bde938b1-0.kLxiFo")).clear(); // Doğru locator'ı kullanın
            driver.findElement(By.cssSelector("input.sc-bde938b1-0.kLxiFo")).sendKeys(destination);

            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                // WebElement antalyaDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-7e3ac4c4-5")));
                // antalyaDiv.click();

                // Doğrudan locator'ı kullanarak elementi bulma
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-7e3ac4c4-5"))).click();

                System.out.println(destination + " bağlantısına tıklandı.");
            } catch (NoSuchElementException e) {
                System.out.println("Hata: " + destination + " bağlantısı bulunamadı.");
            } catch (TimeoutException e) {
                System.out.println("Hata: Popup açılmadı veya belirtilen süre içinde görünmedi.");
            }
        }
    }

    private void clickAntalyaLinkInPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement antalyaDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-7e3ac4c4-5")));
            antalyaDiv.click();
            System.out.println("Antalya bağlantısına tıklandı.");
        } catch (NoSuchElementException e) {
            System.out.println("Hata: Antalya bağlantısı bulunamadı.");
        } catch (TimeoutException e) {
            System.out.println("Hata: Popup açılmadı veya belirtilen süre içinde görünmedi.");
        }
    }


        // ... diğer metotlar

        // Locator örnekleri
        private By datePickerDiv = By.xpath("//div[contains(text(),'Giriş - Çıkış Tarihleri')]");

        public void clickDatePicker() {
            try {
                driver.findElement(datePickerDiv).click();
                System.out.println("Tarih seçiciye tıklandı.");
            } catch (NoSuchElementException e) {
                System.out.println("Hata: Tarih seçici bulunamadı.");
            } catch (Exception e) {
                System.out.println("Bir hata oluştu: " + e.getMessage());
            }
        }
        // ... diğer metotlar

        // Locator örnekleri
        private By adultCountDiv = By.xpath("//div[contains(@class, 'sc-9fbd97d9-16')]/span[contains(@class, 'sc-fd984615-0')]/span[contains(@class, 'sc-eb82d810-0')]");
        private By incrementButton = By.xpath("//button[@data-testid='increment-button']");
        private By adultCountLabel = By.xpath("//span[@data-testid='count-label']");

        public void clickAdultCount() {
            driver.findElement(adultCountDiv).click();
        }

        public void incrementAdultCount() {
            driver.findElement(incrementButton).click();
        }

        public void verifyAdultCountIncreased() {
            String adultCount = driver.findElement(adultCountLabel).getText();
            if (!adultCount.equals("1")) {
                System.out.println("Yetişkin sayısı başarıyla artırıldı: " + adultCount);
            } else {
                System.out.println("Yetişkin sayısı artırılamadı.");
            }
        }
        // ... diğer metotlar

        // Locator örnekleri
        private By searchButton1 = By.xpath("//div[contains(@class, 'sc-3e1e4b64-0')]/button");

    public void clickSearchButtonIfVisible() {
        try {
            WebElement searchButtonElement = driver.findElement(searchButton1);
            if (searchButtonElement.isDisplayed()) {
                searchButtonElement.click();
                System.out.println("Ara butonuna tıklandı.");
            } else {
                System.out.println("Hata: Ara butonu görünür değil.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Hata: Ara butonu bulunamadı.");
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }

        // ... diğer metotlar (popup kapatma işlemi vb.)
    }






    // ... diğer metotlar


        // ... diğer metotlar (enterDestination, clickSearchButton vb.)


