package com.cybertek.tests.day2_NavDemo;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {


    WebDriver driver=WebDriverFactory.getDriver("chrome");
    driver.get("http://www.google.com");
    }
}
