package com.cybertek.tests.day9_Popup_tabs_Frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class popupsAndAlerts {

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
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        WebElement Destroy = driver.findElement(By.xpath("//button[.='Destroy the World']"));

        Destroy.click();;

        WebElement CloseWindow = driver.findElement(By.xpath("//button[.='No']"));
        CloseWindow.click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement ClickButton = driver.findElement(By.xpath("//button[1]"));
        ClickButton.click();
        // switch to JS alert
       Alert alert=driver.switchTo().alert(); // one time it is enough
       Thread.sleep(3000);
       alert.accept();

        WebElement ClickButton2 = driver.findElement(By.xpath("//button[2]"));
        ClickButton2.click();
        Thread.sleep(3000);
        alert.dismiss();

        WebElement ClickButton3 = driver.findElement(By.xpath("//button[3]"));
        ClickButton3.click();
        Thread.sleep(3000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.sendKeys("Test");
         alert.accept();

    }



}
