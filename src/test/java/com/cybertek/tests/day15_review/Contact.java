package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactsInfo;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Contact extends TestBase {

    @Test
    public void Mail() throws InterruptedException {
        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: salesmanager120");
        loginPage.usernameInput.sendKeys("salesmanager120");

        extentLogger.info("Enter Password:UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();

        DashBoardPage dashBoardPage=new DashBoardPage();
        extentLogger.info("Navigate to Contact");
        dashBoardPage.navigateToModule("Customers","Contacts");

        ContactsPage contactsPage=new ContactsPage();
        String searchedEmail=ConfigurationReader.get("testEmail");

        //Verify same mail or not
        System.out.println(contactsPage.getSearchedEmail(searchedEmail).getText());

        //After click account is opened
        extentLogger.info("Click "+searchedEmail);
        contactsPage.getSearchedEmail(searchedEmail).click();


        ContactsInfo contactsInfo  =new ContactsInfo();
        //Verify username
        String username= ConfigurationReader.get("testUsername");
        extentLogger.info("Verify username is "+username);
        Assert.assertEquals(contactsInfo.username.getText(),username,"Verify usernme same");

        //Verify mail
        extentLogger.info("Verify email is "+searchedEmail);
        Assert.assertEquals(contactsInfo.email.getText(),searchedEmail,"Verify mail same");

        //Verify phone
        String phone=ConfigurationReader.get("testPhone");;
        extentLogger.info("Verify phone is "+phone);
        Assert.assertEquals(contactsInfo.phone.getText(),phone,"Verify phone same");





        Thread.sleep(10000);







        extentLogger.pass("Wrong Password Test is Passed");

    }
}
