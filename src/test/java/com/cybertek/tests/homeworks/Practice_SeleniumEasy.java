package com.cybertek.tests.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice_SeleniumEasy {

    WebDriver driver=null;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
    @Test
    public void FindingElements(){


        // ID LOCATOR
        WebElement item1= driver.findElement(By.id("site-name"));
        System.out.println(item1.getText());

        // ClASSNAME LOCATOR
        WebElement item2= driver.findElement(By.className("site-name"));
        System.out.println(item2.getText());

        // TEXT LOCATOR
        WebElement item3= driver.findElement(By.linkText("Date pickers"));
        System.out.println(item3.getText());

        WebElement item4= driver.findElement(By.partialLinkText("TestNG"));
        System.out.println(item4.getText());

        WebElement item5= driver.findElement(By.partialLinkText("Date"));
        System.out.println(item5.getText());

        // XPATH LOCATOR STARTS WİTH

        WebElement item6= driver.findElement(By.xpath("//input[starts-with(@id,'isAge')]"));
        System.out.println(item6.getAttribute("id"));

        // XPATH LOCATOR CONTAINS

        WebElement item7= driver.findElement(By.xpath("//div[contains(text(),'Success')]"));
        System.out.println(item7.getAttribute("id"));


        // XPATH LOCATOR ENDS WITH ıs not working with CHROME

        //WebElement item8= driver.findElement(By.xpath("//input[ends-with(@id,'AgeSelected')]"));
       // System.out.println(item8.getText());

        // CSS ID LOCATOR
        WebElement item9= driver.findElement(By.cssSelector("#site-name"));
        System.out.println(item9.getText());

        // CSS CLASS LOCATOR
        WebElement item10= driver.findElement(By.cssSelector(".site-name"));
        System.out.println(item10.getText());

        // CSS MORE THAN ONE CLASS LOCATOR
        WebElement item11= driver.findElement(By.cssSelector(".collapse.navbar-collapse"));
        System.out.println(item11.getText());

        // CSS LOCATOR STARTS WİTH

        WebElement item12= driver.findElement(By.cssSelector("input[id^='isAge']"));
        System.out.println(item12.getAttribute("value"));

        // CSS LOCATOR CONTAINS

        WebElement item13= driver.findElement(By.cssSelector("input[type*='checkbox']"));
        System.out.println(item13.getAttribute("value"));


        // CSS LOCATOR ENDS WITH is  working with CHROME

        WebElement item14= driver.findElement(By.cssSelector("[id$='AgeSelected']"));
        System.out.println(item14.getText());






    }
}
