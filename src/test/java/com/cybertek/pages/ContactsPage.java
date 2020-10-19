package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ContactsPage extends BasePage {

    @FindBys({

    @FindBy(xpath = "(//td[@data-column-label='Email'])")
    })
    public List<WebElement> email;


    @FindBy(css = ".user-name")
    public WebElement username;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement emails;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phones;



    WebElement findEmail;


    public WebElement getSearchedEmail(String searchedEmail) {
        waitUntilLoaderScreenDisappear();

        for (WebElement webElement : email) {
            if (webElement.getText().equals(searchedEmail)) {
                findEmail=webElement;
                break;            }
        }
        return findEmail;

    }

    // Jamals way
    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }

}


