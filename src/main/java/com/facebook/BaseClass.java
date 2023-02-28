package com.facebook;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class BaseClass  {

    public static WebDriver driver;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    static ConfigReader configReader= ConfigFactory.create(ConfigReader.class);
    private static String userProfileBase;

    @BeforeMethod(alwaysRun = true)
    public static void initDriver(){
        String platform=System.getProperty("platform");

        if(platform.equalsIgnoreCase("web")){
            ChromeOptions options= new ChromeOptions();
            driver= new ChromeDriver(options);
            String web_end_point=configReader.facebookWebEndPoint();
            driver.get(web_end_point);
            driver.manage().window().maximize();
        }
        drivers.set(driver);


    }

    public static WebDriver getDriver(){
        driver= drivers.get();
        return driver;
    }

    public static String getUserProfileHost(){
         userProfileBase=configReader.login_service();
         return userProfileBase;
    }

    @AfterMethod( alwaysRun = true)
    public void quitDriver(){
        drivers.get().quit();
    }




}
