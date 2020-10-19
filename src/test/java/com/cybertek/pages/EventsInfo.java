package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsInfo extends BasePage {

    @FindBy(xpath = " //label[contains(text(),'Title')]")
    public WebElement title;

    @FindBy(xpath = " //label[contains(text(),'Description')]")
    public WebElement description;

    @FindBy(xpath = " //label[contains(text(),'Start')]")
    public WebElement start;

    @FindBy(xpath = " //label[contains(text(),'End')]")
    public WebElement end;

    @FindBy(xpath = " //label[contains(text(),'All-day event')]")
    public WebElement allDayEvent;

    @FindBy(xpath = " //label[contains(text(),'Organizer')]")
    public WebElement organizer;

    @FindBy(xpath = " //label[contains(text(),'Guests')]")
    public WebElement guest;

    @FindBy(xpath = " //label[contains(text(),'Recurrence')]")
    public WebElement recurrance;

    @FindBy(xpath = " //label[contains(text(),'Call via Hangout')]")
    public WebElement callViaHangout;




}
