package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(xpath="//button[@name='login']")
    WebElement loginBtn;


    @FindBy(xpath = "//div[@class='_9ay7']")
    WebElement invalidPwdError;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void enterEmail(String emailId){
        email.sendKeys(emailId);
    }

    public void enterPwd(String pwd){
        password.sendKeys(pwd);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public String getInvalidPwdMessage(){

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf((invalidPwdError)));

        String error=invalidPwdError.getText();
        return error;
    }

}
