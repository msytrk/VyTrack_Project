package com.cybertek.tests.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hw2Tc6To8 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

    }



    @Test       // Mouse over and How can Verify new mail ?????
    public void test6() throws InterruptedException {


        driver.get("https://www.tempmailaddress.com/");
        // find Registration form element
        String email=driver.findElement(By.cssSelector("#email")).getText();
        System.out.println("email = " + email);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        System.out.println("Test");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        System.out.println("Test");
        driver.findElement(By.name("full_name")).sendKeys("Mehmet");
        driver.findElement(By.name("email")).sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".radius")).click();
        WebElement signupMessage = driver.findElement(By.cssSelector("*[name=signup_message]"));

        // Message is Displayed
        Assert.assertTrue(signupMessage.isDisplayed());
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(3000);
        // Verify mail
        WebElement from = driver.findElement(By.xpath("//td[@class='from']"));
        String actualResult = from.getText();
        String expectedResult = " do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualResult,expectedResult);
        // Mouse Over
        Actions actions = new Actions(driver);
        actions.moveToElement(from).perform();
        Thread.sleep(1000);
        //Click
        from.click();
        String fromWho = driver.findElement(By.xpath("//*[@id='odesilatel']")).getText();
        expectedResult = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(fromWho,expectedResult);

        String subject = driver.findElement(By.xpath("//*[@id='predmet']")).getText();
        expectedResult="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(subject,expectedResult);





        Thread.sleep(7000);



    }


    @Test
    public void test7() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        // Upload choice
        WebElement upload = driver.findElement(By.id("file-upload"));
        // Upload path
        upload.sendKeys("/Users/soyturk/Desktop/Test.txt");
        Thread.sleep(3000);
        driver.findElement(By.id("file-submit")).click();

        WebElement message=driver.findElement(By.cssSelector(".example > h3"));
        Thread.sleep(3000);
        // Success message
        System.out.println("message.getText() = " + message.getText());
        Assert.assertTrue(message.isDisplayed(),"File Uploaded! Message is NOT displayed");



    }

    @Test
    public void test8() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.name("myCountry")).sendKeys("United States of America");
        WebElement message=driver.findElement(By.cssSelector(".autocomplete-items>div>strong"));
        System.out.println("message.getText() = " + message.getText());
        Assert.assertTrue(message.isDisplayed(),"Autocomplete is not working ");
    }

}
