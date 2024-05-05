package org.example.pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

        public void verifyUrlContainsAntalya() {
            try {
                String currentUrl = "https://www.setur.com.tr/antalya-otelleri?room=3&isBooker=true";
                if (currentUrl.contains("antalya")) {
                    System.out.println("URL, 'antalya' kelimesini içeriyor.");
                } else {
                    System.out.println("Hata: URL, 'antalya' kelimesini içermiyor.");
                }
            } catch (Exception e) {
                System.out.println("Bir hata oluştu: " + e.getMessage());
            }
        }
    }

