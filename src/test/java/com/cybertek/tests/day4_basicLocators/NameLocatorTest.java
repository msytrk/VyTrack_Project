package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name=driver.findElement(By.name("full_name"));
        name.sendKeys("mehmet SOYTÜRK");
        name.click();

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("mhmtsytrk@outlook.com");
        email.click();

        WebElement button=driver.findElement(By.name("wooden_spoon"));
        button.click();





    }
}
