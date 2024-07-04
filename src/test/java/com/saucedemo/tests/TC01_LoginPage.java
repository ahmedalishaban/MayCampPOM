package com.saucedemo.tests;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TC01_LoginPage {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void validLogin(){
    loginPage = new LoginPage(driver);

    loginPage.getLoginPage();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.verifyLoginPage(),"validLogin");

    }


    @Test(priority = 2)
    public void invalidLogin(){
        loginPage = new LoginPage(driver);
        SoftAssert soft = new SoftAssert();


        loginPage.getLoginPage();
        loginPage.enterUsername("xyz");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

            soft.assertTrue(loginPage.verifyErrorMessage(),"error message");
            soft.assertAll();

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }






}
