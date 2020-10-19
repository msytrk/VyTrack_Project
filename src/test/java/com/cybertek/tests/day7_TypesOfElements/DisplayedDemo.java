package com.cybertek.tests.day7_TypesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

    WebElement userNameInput = driver.findElement(By.cssSelector("#username"));


        // verify username is not display on screen
        Assert.assertFalse(userNameInput.isDisplayed(),"Verify that is not displayed");
        // Click start butto
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        Thread.sleep(6000);
        // Verify username is displayed

        Assert.assertTrue(userNameInput.isDisplayed(),"Verify that is  displayed");


        driver.quit();
    }
}