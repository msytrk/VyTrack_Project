package com.cybertek.tests.day7_TypesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons

        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue" ));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        // How to check is selected or not
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());


        Assert.assertTrue(blueRadioBtn.isSelected(),"Verify that is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"Verify that is not selected");
        // how to click RadioButton
        redRadioBtn.click();

        // Verify them
        Assert.assertFalse(blueRadioBtn.isSelected(),"Verify that is selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"Verify that is not selected");
        Thread.sleep(3000);
        driver.quit();


    }


}
