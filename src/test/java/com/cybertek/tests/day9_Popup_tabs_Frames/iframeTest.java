package com.cybertek.tests.day9_Popup_tabs_Frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        Thread.sleep(3000);

        //Switch to Frame   1. NameOrID
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike");

        driver.switchTo().defaultContent();  // turning back first frame (Main HTML) when we have multiple iframes

        //Switch to Frame   2. Index

        driver.switchTo().frame(0); // another one goes 0,1,2,3,4,5,6,7 etc...
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smth with INDEX");
        Thread.sleep(3000);
        // Second way to switch Parent Frame / Main HTML One step back
        driver.switchTo().parentFrame();

        //Switch to Frame   3. Using WebElement
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smth with IFRAME");
        Thread.sleep(3000);





    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.id("content")).getText());

         // Goes back top frame
        driver.switchTo().parentFrame();
        //driver.switchTo().frame("frame-right");
        driver.switchTo().frame(2);

        System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.tagName("body")).getText());


        // Goes back top of the frames
        driver.switchTo().defaultContent();
        // Goes frame-bottom
        driver.switchTo().frame(1);
        System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.tagName("body")).getText());








    }
}
