package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {


    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "[class='btn btn-link dropdown-toggle']")
    public WebElement optionsSection;

    @FindBy(css = "[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement viewPerPageNumber;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement totalRecordNumber;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> totalRow;

    @FindBy(xpath = "//table//th[1]//input")
    public WebElement  checkBox ;

    @FindBy(xpath = "//table//tbody/tr")
    public List<WebElement> allCheckBox ;

    @FindBy(xpath = "//a[@data-grid-pagination-direction='next']")
    public WebElement  nextButton ;

    @FindBy(xpath="//td[contains(text(),'Testers meeting')]")
    public WebElement event;


    public int getRow(){
        int totalNumberRow=0;
        String str="";
        do{
            totalNumberRow+=totalRow.size();
            str= Driver.get().getCurrentUrl();
            nextButton.click();
            waitUntilLoaderScreenDisappear();
        }while(!Driver.get().getCurrentUrl().equals(str));

        return totalNumberRow;
    }

    public boolean getIsCheck(){
        boolean flag=true;
        String str="";
        do{
            str= Driver.get().getCurrentUrl();
            for (WebElement checkbox : allCheckBox) {
                System.out.println(allCheckBox.get(1).getText());
                if(!checkbox.getAttribute("class").contains("row-selected")) {
                    flag = false;
                    break  ;
                }
            }
            nextButton.click();
            waitUntilLoaderScreenDisappear();
        }while(!Driver.get().getCurrentUrl().equals(str));

        return flag;
    }

    public WebElement getTıtle(String tıtle){
        String xpath ="//td[contains(text(),'"+tıtle+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public WebElement getInformation(int x){
        String xpath ="//div[@class='responsive-block'][1]/div['"+x+"']";
        return Driver.get().findElement(By.xpath(xpath));
    }





}