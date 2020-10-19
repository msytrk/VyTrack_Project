package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Opening");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Closing");
    }

    @Test
    public void test1(){


        System.out.println("First");

        Assert.assertEquals("title","Title ");

        System.out.println("Second");

        Assert.assertEquals("url","URL ","Verify title is not equals");

    }

    @Test
    public void test2(){
        System.out.println("Second TestCase");
    }

    @Test
    public void test3(){
        String expected="Cyb";
        String actual="Cybertek";
        Assert.assertTrue(actual.startsWith(expected),"Verify Title starts with Cyb");
    }

    @Test
    public void test4(){
        String expected="aaa@@gmail.com";
        Assert.assertTrue(expected.contains("@"),"verifiying contains @");
    }

    @Test
    public void test5(){

        Assert.assertFalse(0>1,"verify that 0 not greater than 1");
    }
    @Test
    public void test6(){

        Assert.assertNotEquals("url","URL ","Verify title is not equals");
    }

}
