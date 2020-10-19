package com.cybertek.tests.day8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDowns {


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
        WebElement dropdown = driver.findElement(By.id("state"));
        //Create Select Object to Use methods
        Select stateDropdown=new Select(dropdown);
        //getoptions returns List<WebElement>
        List<WebElement> options = stateDropdown.getOptions();


        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }


        
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));

        Select stateDropdown=new Select(dropdown);
        String actualResult=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult,"Select a State","Verify First selection");

        Thread.sleep(3000);

        // SelectByVisibleText
        stateDropdown.selectByVisibleText("Virginia");
        Thread.sleep(3000);
        actualResult=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,"Virginia","Verify selection");
        //SelectByIndex
        stateDropdown.selectByIndex(51);
        Thread.sleep(3000);
        actualResult=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,"Wyoming","Verify selection");

        //SelectByValue

        stateDropdown.selectByValue("TX");
        Thread.sleep(3000);
        actualResult=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,"Texas","Verify selection");

    }


}
