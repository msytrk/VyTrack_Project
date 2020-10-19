package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {
/*VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){


            LoginPage loginPage = new LoginPage();
            //Login as driver
            loginPage.loginAsDriver();

            DashBoardPage dashboardPage = new DashBoardPage();
            //Go to Activities->Calendar Events
            dashboardPage.navigateToModule("Activities", "Calendar Events");

            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            //Click on create calendar events
            //wait for loader mask
            calendarEventsPage.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent, 5);
            calendarEventsPage.createCalendarEvent.click();

            CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
            // Click on repeat
            createCalendarEventsPage.repeat.click();

            //Verify that repeat every days is checked
            Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Verify repeat days is selected");
            //verify that repeat weekday is not checked
            Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Verify weekday is not selected");


        }




             /*
        VERIFY REPEAT OPTIONS
           Open browser
           Login as driver
           Go to Activities->Calendar Events
           Click on create calendar events button
           Click on repeat checkbox
           Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        */


    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();
        //Login as driver
        loginPage.loginAsDriver();

        DashBoardPage dashboardPage = new DashBoardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent, 5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();


        // After this line we can access Select Object methods ( SelectBy...)
        Select repeatsDropdown=createCalendarEventsPage.repeatOptionsList();
        // expectedlist
        List<String>  expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");
        // actualList
        List<String>  actualList= new ArrayList<>();
        // take them a list
        List<WebElement> actualOptions=repeatsDropdown.getOptions();
        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
        }
        // Short way to take WebElements as a String List with methods actualList2.this is ready method from BrowserUtil
        List<String> actualList2=BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList2,expectedList,"Verify that correct order");















    }
}
