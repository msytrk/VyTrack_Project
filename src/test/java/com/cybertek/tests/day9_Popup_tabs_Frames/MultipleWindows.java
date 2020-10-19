package com.cybertek.tests.day9_Popup_tabs_Frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void switchWindowTest(){
        driver.get("http://practice.cybertekschool.com/windows");
        // Before Click
        System.out.println("before = " + driver.getTitle());
        String beforeTitle=driver.getTitle();

        driver.findElement(By.linkText("Click Here")).click();
        // after
        System.out.println("after = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String handle=driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        // Set is a unique List and there is no order
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(handle))
                driver.switchTo().window(windowHandle);
        }

        System.out.println("after = " + driver.getTitle());
        String afterTitle=driver.getTitle();;

        Assert.assertNotEquals(beforeTitle,afterTitle,"Verify that are equals");



    }

    @Test
    public void moreThanTwo(){

        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        // Before Switch
        System.out.println("before = " + driver.getTitle());
        String currentOne=driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle) ;
            if(driver.getTitle().equals("New Window"))
                break;
        }

        // After Switch
        System.out.println("after = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"New Window","Verify that are equals");

    
    }

}
