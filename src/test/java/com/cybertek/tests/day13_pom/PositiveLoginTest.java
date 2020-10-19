package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage lp=new LoginPage();

        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");

        lp.usernameInput.sendKeys(username);
        lp.passwordInput.sendKeys(password);
        lp.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStoreManager(){

        LoginPage lp=new LoginPage();

        //  lp.loginAsStoreManager();

        //lp.loginOptional("storemanager");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }


}
