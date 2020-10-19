package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitEx {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("div[id='start']>button")).click();
        WebElement userInput=driver.findElement(By.id("username"));

        // HOW TO WAIT EXPLICITLY
        // CREATE AN OBJECT
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(userInput));



        userInput.sendKeys("MikeSmith");



    }


    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        // enable button
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        // input box
        WebElement inputBox=driver.findElement(By.cssSelector("#input-example>input"));
        // create WebDriverWait Object
        WebDriverWait wait=new WebDriverWait(driver,10);
        // control condition
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        //sendKeys
        inputBox.sendKeys("Mike Smith");





    }
}
