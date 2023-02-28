package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Accounts {

    WebDriver driver;

    public Accounts(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    public String getProfileName(String userName){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath("//span[contains(text(),'"+userName+"')]")))));

        String name=driver.findElement(By.xpath("//span[contains(text(),'"+userName+"')]")).getText();
        System.out.println(name);
        return name;
    }

}
