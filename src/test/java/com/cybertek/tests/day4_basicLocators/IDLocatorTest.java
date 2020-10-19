package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement disbutton=driver.findElement(By.id("disappearing_button"));
        System.out.println("disbutton.getText() = " + disbutton.getText());
        disbutton.click();


        driver.quit();

    }
}
