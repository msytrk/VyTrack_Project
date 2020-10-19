package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinktextLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement links=driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        links.click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);

        WebElement partialLinks=driver.findElement(By.partialLinkText("Example 1"));
        partialLinks.click();
        Thread.sleep(5000);

    }
}
