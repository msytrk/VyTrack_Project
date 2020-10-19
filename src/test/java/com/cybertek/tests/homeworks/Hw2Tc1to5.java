package com.cybertek.tests.homeworks;

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
import java.util.concurrent.TimeUnit;

public class Hw2Tc1to5 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {

        driver.findElement(By.name("birthday")).sendKeys("TestData");
        // locating element with text
        WebElement warn=driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        // is Dİsplayed
        Assert.assertTrue(warn.isDisplayed(),"Warn Message is not displayed ");

    }

    @Test
    public void test2() throws InterruptedException {

        WebElement c=driver.findElement(By.xpath("//*[@id='inlineCheckbox1']"));
        WebElement java=driver.findElement(By.xpath("//*[@id='inlineCheckbox2']"));
        WebElement js=driver.findElement(By.xpath("//*[@id='inlineCheckbox3']"));

        Assert.assertTrue(c.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(js.isDisplayed());


    }

    @Test
    public void test3() throws InterruptedException {

        WebElement firstname=driver.findElement(By.name("firstname"));
        firstname.sendKeys("a");
        // locating element with text
        WebElement warn=driver.findElement(By.xpath("//*[.='first name must be more than 2 and less than 64 characters long']"));
        // is Displayed
        Assert.assertTrue(warn.isDisplayed(),"Warn Message is not displayed");

    }

    @Test
    public void test4() throws InterruptedException {

        // Find lastname
        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("a");
        // locating element with text
        WebElement warn=driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warn.isDisplayed(),"Warn Message is not displayed");

    }

    @Test
    public void test5() throws InterruptedException {

        // Find lastname
        driver.findElement(By.name("firstname")).sendKeys("Mehmet");
        driver.findElement(By.name("lastname")).sendKeys("Soyturk");
        driver.findElement(By.name("username")).sendKeys("Ankarali");
        driver.findElement(By.name("email")).sendKeys("email@email.com");
        driver.findElement(By.name("password")).sendKeys("Unutma01-");
        driver.findElement(By.name("phone")).sendKeys("555-555-5555");
        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("10/10/2000");
        //DROPDOWNS Department
        WebElement dropdownDepartment = driver.findElement(By.name("department"));
        Select dropdown=new Select(dropdownDepartment);
        dropdown.selectByVisibleText("Department of Engineering");
        //DROPDOWNS JOB
        WebElement dropdownJob = driver.findElement(By.name("job_title"));
        dropdown=new Select(dropdownJob);
        dropdown.selectByVisibleText("SDET");
        Thread.sleep(3000);
        //CheckBox is Selected
        driver.findElement(By.xpath("//*[@id='inlineCheckbox2']")).click();
        Thread.sleep(3000);
        List<WebElement> selectedSituationLanguage = driver.findElements(By.cssSelector(".form-check-label"));


        Thread.sleep(5900);
        //Click Sign Up
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(3000);
        //Take alert message
        String actualResult = driver.findElement(By.xpath("//div[@class='alert alert-success']/p[1]")).getText();
        String expectedResult="You've successfully completed registration!";

        Assert.assertEquals(actualResult,expectedResult);


    }

    @Test
    public void test6() throws InterruptedException {

        List<WebElement> selectedSituationLanguage = driver.findElements(By.cssSelector(".form-check-label"));

        for (WebElement webElement : selectedSituationLanguage) {
            System.out.println("webElement.isSelected() = " + webElement.isSelected());
            webElement.click();
        }

        Thread.sleep(10000);

        for (WebElement webElement : selectedSituationLanguage) {
                System.out.println("webElement.isSelected() = " + webElement.isSelected());
            webElement.click();
        }

        Thread.sleep(5900);

    }


}
