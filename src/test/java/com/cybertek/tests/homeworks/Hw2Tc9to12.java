package com.cybertek.tests.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hw2Tc9to12 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // find Registration form element
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {

        driver.findElement(By.linkText("200")).click();
        WebElement message=driver.findElement(By.xpath("//div[@class='example']"));
        String actualResult = message.getText();
        Assert.assertTrue(message.isDisplayed());




    }

    @Test
    public void test2() throws InterruptedException {

        driver.findElement(By.linkText("301")).click();
        WebElement message=driver.findElement(By.xpath("//div[@class='example']"));
        String actualResult = message.getText();
        System.out.println("actualResult = " + actualResult);
        Assert.assertTrue(message.isDisplayed());




    }
    @Test
    public void test11() throws InterruptedException {

        driver.findElement(By.linkText("404")).click();
        WebElement message=(driver.findElement(By.xpath("//div/p")));
        String mes= message.getText();
        System.out.println("message.getText() = " + message.getText());

        Assert.assertTrue(mes.contains("404"));




    }
    @Test
    public void test4() throws InterruptedException {

        driver.findElement(By.linkText("500")).click();
        WebElement message=driver.findElement(By.xpath("//div[@class='example']"));
        String actualResult = message.getText();
        System.out.println("actualResult = " + actualResult);

        Assert.assertTrue(message.isDisplayed());




    }

}
