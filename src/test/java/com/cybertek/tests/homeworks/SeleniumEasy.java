package com.cybertek.tests.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumEasy {
     WebDriver driver=null;

    @BeforeMethod
    public void setup(){

       driver = WebDriverFactory.getDriver("chrome");
       driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }


    @Test
    public void test1() throws InterruptedException {

        // Verify that message is not shown
        WebElement message= driver.findElement(By.xpath("//div[@id='txtAge']"));
        Assert.assertFalse(message.isDisplayed());
        // Click combobox
        WebElement cbox= driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        cbox.click();
        Thread.sleep(3000);
        // Verify that message is shown
        Assert.assertTrue(message.isDisplayed());

    }

    @Test
    public void test2() throws InterruptedException {

        // Verify that message is not shown
        WebElement checkAll= driver.findElement(By.xpath("//input[@id='check1']"));

        // Verify that message is equals  "Check All"
        Assert.assertEquals(checkAll.getAttribute("value"),"Check All");
        checkAll.click();
        Thread.sleep(3000);


        // Verify all cbox are selected
        WebElement cbox1= driver.findElement(By.xpath("//*[text()='Option 1']/input"));
        Assert.assertTrue(cbox1.isSelected());

        WebElement cbox2= driver.findElement(By.xpath("//*[text()='Option 2']/input"));
        Assert.assertTrue(cbox2.isSelected());

        WebElement cbox3= driver.findElement(By.xpath("//*[text()='Option 3']/input"));
        Assert.assertTrue(cbox3.isSelected());

        WebElement cbox4= driver.findElement(By.xpath("//*[text()='Option 4']/input"));
        Assert.assertTrue(cbox4.isSelected());

        // Verify that message is equals  "Uncheck All"
        Assert.assertEquals(checkAll.getAttribute("value"),"Uncheck All");



    }
    @AfterMethod
    public void tearDown(){

            driver.quit();

    }


}
