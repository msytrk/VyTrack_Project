package com.cybertek.tests.day11_webTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTablesEx {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getTable(){
        WebElement table=driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table.getText() = " + table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));



    }

    @Test
    public void getAllHeaders(){

        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
        // locating table 1 headers
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());
        }

    }
    @Test
    public void printTableSize(){
        // WITH HEADER
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        // locating table 1 headers
        System.out.println("rows.size() = " + rows.size());

        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());
        }
        //WITHOUT HEADER ( Prefer this one )
        List<WebElement> rows1=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        // locating table 1 headers
        System.out.println("rows1.size() = " + rows1.size());

        for (WebElement row1 : rows1) {
            System.out.println("row1.getText() = " + row1.getText());
        }

    }
    @Test
    public void getRow(){

        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row.getText());
        // get all rows dynamically
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement webElement : rows) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }

        for (int i = 1; i <= rows.size(); i++) {
            WebElement roww=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(roww.getText());
        }



    }
    @Test
    public void getAllCellinRow(){
       List<WebElement>  rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));

        for (int i = 1; i < rows.size(); i++) {
             WebElement cell=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td["+i+"]"));
            System.out.println(cell.getText());

        }
        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());

        }

    }

    @Test
    public void getAllSingleCellinRow(){
        WebElement  row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[5]"));

        System.out.println("row.getText() = " + row.getText());

    }

    @Test

    public void printAllCellsByIndex(){




        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <= colNumber; j++) {

                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }
            System.out.println();

        }



    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return  headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return  allRowsWithoutHeader.size();
    }



    @Test
    // Control it But not enough
    public void printAllCellsByIndex2() {
        List<WebElement>  columns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
        List<WebElement>  rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println(columns.size());
        System.out.println(rows.size());

            for (WebElement column : columns) {
                System.out.print (column.getText() + "  ");
            }




    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName="Jason";

        String xpath ="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }








}





