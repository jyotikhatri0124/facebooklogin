package com.facebook.utils;

import com.facebook.BaseClass;
import com.facebook.pages.Accounts;
import com.facebook.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginUtils extends BaseClass {

    LoginPage loginPage;
//    WebDriver driver;
    Accounts accounts;

    public void login(String email,String password) {


        loginPage = new LoginPage(getDriver());
        loginPage.enterEmail(email);
        loginPage.enterPwd(password);
        loginPage.clickLogin();
    }

    public void verifyProfileName(String expectedName){
        accounts=new Accounts(getDriver());
        String actualName = accounts.getProfileName(expectedName);
        Assert.assertTrue(actualName.equals(expectedName), "User name in profile section is not correct");
    }

    public void verifyErrorName(String expectedError){
        accounts=new Accounts(getDriver());
        String actualError = loginPage.getInvalidPwdMessage();
        System.out.println(actualError);
        Assert.assertTrue(actualError.equals(expectedError), "Error Message is not valid "+actualError);
    }
}
