package com.cybertek.tests.day8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDowns {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdownMenuLink"));

        // click dropdown to see available options
        dropdown.click();
        // Locate with common
        List<WebElement> dropdowns = driver.findElements(By.className("dropdown-item"));
        // write each of them
        for (WebElement button : dropdowns) {
            System.out.println("button.getText() = " + button.getText());
        }
        //size
        System.out.println("dropdowns.size() = " + dropdowns.size());

        //Click second one
        dropdowns.get(2).click();

    }



    }

