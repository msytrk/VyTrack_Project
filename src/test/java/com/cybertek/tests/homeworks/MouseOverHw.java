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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseOverHw {


    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> imgList = driver.findElements(By.xpath("//div[@class='figure']"));
        //Actions --> class that contains all the user interactions
        //how to create actions object --> passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform() --> perform the action, complete the action
        //moveToElement --> move you mouse to webelement(hover over)
        Thread.sleep(2000);


        int count =1 ;
        String wordLocator;
        String nameLocator;
        String imageLocator;

        for (WebElement img : imgList) {
            actions.moveToElement(img).perform();
            Thread.sleep(2000);
            // Find element position dynamicly
            wordLocator="//a[@href='/users/"+Integer.toString(count)+"']";
            nameLocator="(//div/h5)["+Integer.toString(count)+"]";
            imageLocator="(//img[@src='/img/avatar-blank.jpg'])["+Integer.toString(count)+"]";

            WebElement viewLink= driver.findElement(By.xpath(wordLocator));
            WebElement name= driver.findElement(By.xpath(nameLocator));
            WebElement image= driver.findElement(By.xpath(imageLocator));

            String names=img.getText();
            System.out.println(names);


            Assert.assertTrue(viewLink.isDisplayed(),"link is not displayed");
            Assert.assertTrue(name.isDisplayed(),"name is not displayed");
            Assert.assertTrue(image.isDisplayed(),"image is not displayed");

            count++;



        } }
        @Test
        public void test3() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/hovers");
            Actions action = new Actions(driver);
            List<WebElement> img = driver.findElements(By.xpath("//*[@class='figure']"));
            for (WebElement webElement : img) {
                Thread.sleep(1000);
                action.moveToElement(webElement).perform();
                String name = webElement.getText();
                System.out.println(name);
                Assert.assertTrue(webElement.isDisplayed(), "name is  displayed");


            }
        }}


