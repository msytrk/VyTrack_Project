package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword(){

        LoginPage lp=new LoginPage();

        lp.usernameInput.sendKeys("user1");
        // wrong Password
        lp.passwordInput.sendKeys("somepassword");
        lp.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsername(){

        LoginPage lp=new LoginPage();

        lp.usernameInput.sendKeys("wrongUser");
        // wrong Password
        lp.passwordInput.sendKeys("UserUser123");
        lp.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }







}
