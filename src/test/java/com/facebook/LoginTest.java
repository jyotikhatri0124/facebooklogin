package com.facebook;

import com.facebook.constants.DataConstants;
import com.facebook.models.UserProfileResponse;
import com.facebook.pages.Accounts;
import com.facebook.pages.LoginPage;
import com.facebook.utils.LoginUtils;
import com.facebook.utils.ApiUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{

    LoginUtils loginUtils;
    ApiUtils apiUtils;

    @Test(dataProvider = "login_data")
    public void verifyLogin(String email,String password,boolean emailValid,boolean pwdValid){
        loginUtils= new LoginUtils();
        loginUtils.login(email,password);
        System.out.println("login done");


        if(emailValid && pwdValid) {
            apiUtils= new ApiUtils();
            UserProfileResponse userProfileResponse=apiUtils.getUserProfileDetails(email);
            String expectedName = userProfileResponse.getUsername();
            loginUtils.verifyProfileName(expectedName);

        }else if(!pwdValid){
            loginUtils.verifyErrorName(DataConstants.PWD_INVALID_ERROR);


        }
    }


    @DataProvider(name = "login_data")
    public Object[][] getLoginData(){
        Object[][] data={{"jkhatri0009@gmail.com","test@123",true,true},{"jkhatri0009@gmail.com","",true,false}};
        return data;
    }

}


