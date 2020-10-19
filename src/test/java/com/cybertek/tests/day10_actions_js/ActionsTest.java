package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest {


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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the user interactions
        //how to create actions object --> passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform() --> perform the action, complete the action
        //moveToElement --> move you mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();
        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed");



    }


    @Test

        public void dragAndDrop() throws InterruptedException {
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
            driver.manage().window().maximize();

            Actions actions = new Actions(driver);
        // To close cookies
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));

        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }
        // Std way
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));


        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();


    }

    @Test

    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        // To close cookies
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));

        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }
        // Std way
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        System.out.println(target.getLocation());


        Thread.sleep(2000);
        // Pause is not necessary only for see how can it use.Long way drag and drop
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


    }




}




