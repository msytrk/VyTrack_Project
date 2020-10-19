package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void beforeClass(){

        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){

        System.out.println("After Class");
        System.out.println("Some reporting here");
    }
    @Test
    public void Test1(){
        System.out.println("First TestCase");

    }
    @Test
    public void Test2(){
        System.out.println("Second TestCase");

    }
    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver Opening");


    }
    @AfterMethod
    public void tearDown(){
        System.out.println("WebDriver Closing");


    }
}
