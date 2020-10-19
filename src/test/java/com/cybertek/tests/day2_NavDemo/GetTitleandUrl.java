package com.cybertek.tests.day2_NavDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleandUrl {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        System.out.println(driver.getTitle());
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
