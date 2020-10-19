package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement email=driver.findElement(By.name("email"));
        String expectedEmail="msytrk@gmail.com";
        System.out.println("expectedEmail = " + expectedEmail);
        email.sendKeys(expectedEmail);
        String actualEmail=email.getAttribute("value");
        // Generelly we use for ınput getAttribute();
        System.out.println("actualEmail = " + actualEmail);


        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            WebElement retrievePassword=driver.findElement(By.id("form_submit"));
            retrievePassword.click();
            WebElement conf=driver.findElement(By.name("confirmation_message"));
            // This type webelement so we should use getText
            if(conf.getText().equalsIgnoreCase("Your e-mail's been sent!"))
                System.out.println("Test passed");
            else
                System.out.println("test failed");


        }
        driver.quit();
    }
}
