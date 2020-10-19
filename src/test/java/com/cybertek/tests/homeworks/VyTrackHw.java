package com.cybertek.tests.homeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.EventsInfo;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VyTrackHw extends TestBase {

    @Test
    public void Options() {
        extentLogger = report.createTest("Options is Displayed Test ");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username:" + ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("Enter Password:" + ConfigurationReader.get("salesmanager_password"));
        loginPage.loginAsSalesManager();

        //Navigate to Activities > CalendarEvents

        DashBoardPage dashBoardPage = new DashBoardPage();
        extentLogger.info("Open Activities > Calendar Events Page");
        dashBoardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);

        //Options is Displayed or Not

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Check option is displayed or not ");
        Assert.assertTrue(calendarEventsPage.optionsSection.isDisplayed());

    }

    @Test
    public void PageNumber() {
        extentLogger = report.createTest("Page Number is Equall 1");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username:" + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter Password:" + ConfigurationReader.get("storemanager_password"));
        loginPage.loginAsStoreManager();

        //Navigate to Activities > CalendarEvents

        DashBoardPage dashBoardPage = new DashBoardPage();
        extentLogger.info("Open Activities > Calendar Events Page");
        dashBoardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);

        // Verify that page number is equals to "1"
        extentLogger.info("Verify that page number is equals to \"1\"");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"), "1");


    }

    @Test
    public void PageItem() {
        extentLogger = report.createTest("Default PageItem size  25");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username:" + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter Password:" + ConfigurationReader.get("storemanager_password"));
        loginPage.loginAsStoreManager();

        //Navigate to Activities > CalendarEvents

        DashBoardPage dashBoardPage = new DashBoardPage();
        extentLogger.info("Open Activities > Calendar Events Page");
        dashBoardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);

        // Verify that page item is equals to "25"
        extentLogger.info("Verify that view per page number is equals to 25");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.viewPerPageNumber.getText(), "25");


    }

    @Test
    public void TestCase4(){

     /*   1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in
        the table) is equals to number of records
      */
        extentLogger=report.createTest("Verify Number of Calendar events");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashBoardPage dashboardPage=new DashBoardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        extentLogger.info("Verify that number of calendar events (rows in\n" +
                "the table) is equals to number of records");

        BrowserUtils.waitFor(5);


        Assert.assertTrue(calendarEventsPage.totalRecordNumber.getText().contains(Integer.toString(calendarEventsPage.getRow())));

        extentLogger.pass("Pass");

    }
    @Test
    public void TestCase5(){
     /*   1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Click on the top checkbox to select all
        5. Verify that all calendar events were selected
      */

        extentLogger=report.createTest("Verify All Calendar Events selected");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashBoardPage dashboardPage=new DashBoardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(10);

        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.checkBox.click();

        extentLogger.info("Verify that all calendar events were selected");

        Assert.assertTrue(calendarEventsPage.getIsCheck(),"verify all calendar events selected");

    }

    @Test
    public void testersMeeting() {
        extentLogger = report.createTest("testersMeeting");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username:" + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter Password:" + ConfigurationReader.get("storemanager_password"));
        loginPage.loginAsStoreManager();

        //Navigate to Activities > CalendarEvents

        DashBoardPage dashBoardPage = new DashBoardPage();
        extentLogger.info("Open Activities > Calendar Events Page");
        dashBoardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.event.click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        EventsInfo eventsInfo=new EventsInfo();
        Assert.assertTrue(eventsInfo.title.isDisplayed());
        Assert.assertTrue(eventsInfo.description.isDisplayed());
        Assert.assertTrue(eventsInfo.start.isDisplayed());
        Assert.assertTrue(eventsInfo.end.isDisplayed());
        Assert.assertTrue(eventsInfo.allDayEvent.isDisplayed());
        Assert.assertTrue(eventsInfo.organizer.isDisplayed());
        Assert.assertTrue(eventsInfo.guest.isDisplayed());
        Assert.assertTrue(eventsInfo.recurrance.isDisplayed());
        Assert.assertTrue(eventsInfo.callViaHangout.isDisplayed());


    }



}