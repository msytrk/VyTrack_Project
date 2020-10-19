package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedUrl=driver.getCurrentUrl();

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("msytrk@gmail.com");
        WebElement retrieve=driver.findElement(By.id("form_submit"));
        retrieve.click();
        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equalsIgnoreCase(actualUrl))
            System.out.println("Test Failed");
        else
            System.out.println("Test Passed");




    }
}
