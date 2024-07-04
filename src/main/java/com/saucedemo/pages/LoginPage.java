package com.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    //driver
    private final WebDriver driver;

    //elements
    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator= By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");


    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //actions

    public void getLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    //validation
    public boolean verifyLoginPage(){
        return driver
                .getCurrentUrl()
                .equals("https://www.saucedemo.com/inventory.html");
    }

    public boolean verifyErrorMessage(){
        return  driver.findElement(errorMessage)
                .getText()
                .equals("Epic sadface: Username and password do not match any user in this service");
    }


}
