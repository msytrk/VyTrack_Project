package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1(){

        LoginPage lp=new LoginPage();

        lp.loginAsDriver();

        DashBoardPage dashBoardPage=new DashBoardPage();
        String expectedSubTitle = "Quick Launchpad";
        String actualSubTitle = dashBoardPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle,expectedSubTitle,"Verify Subtitle");

        dashBoardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(3); // To pass loader screen
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify Subtitle Calendar Events ");
        // Lazy way is good pactice for environment




    }
}

