package com.cybertek.tests.day10_fileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        // Upload path
        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";
        String fullPath =projectPath+"/"+filePath;
        upload.sendKeys(fullPath);
        Thread.sleep(3000);
        driver.findElement(By.id("file-submit")).click();

        WebElement message=driver.findElement(By.cssSelector(".example > h3"));
        Thread.sleep(3000);
        // Success message
        System.out.println("message.getText() = " + message.getText());
        Assert.assertTrue(message.isDisplayed(),"File Uploaded! Message is NOT displayed");

    }


}
