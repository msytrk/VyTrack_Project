package com.cybertek.tests.day10_fileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilePathEx {

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
    public void test2() throws InterruptedException {
        System.out.println(System.getProperty("user.dir"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";
        String fullPath =projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

    }
}
