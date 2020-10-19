package com.cybertek.tests.day7_TypesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement cBox1= driver.findElement(By.xpath("//input[1]"));
        WebElement cBox2= driver.findElement(By.xpath("//input[2]"));

        // How to verify

        System.out.println("cBox1 = " + cBox1.isSelected());
        System.out.println("cBox2 = " + cBox2.isSelected());

        // verify cbox1 is not selected,2 is selected

        Assert.assertFalse(cBox1.isSelected(),"verify not selected");
        Assert.assertTrue(cBox2.isSelected(),"verify  selected");

        cBox1.click();

        // verify after click

        Assert.assertTrue(cBox1.isSelected(),"verify  selected");
        Assert.assertTrue(cBox1.isSelected(),"verify  selected");

        driver.quit();



    }
}
