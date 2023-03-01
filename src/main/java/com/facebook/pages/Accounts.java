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


public class Accounts {

    WebDriver driver;
    @FindBy(id = "email")
    WebElement email;

    public Accounts(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement getUserName(String userName){
        WebElement element= driver.findElement(By.xpath("//span[contains(text(),'"+userName+"')]"));
        return element;
    }


    public String getProfileName(String userName){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.ignoring(NoSuchElementException.class);
        WebElement userNameEle= getUserName(userName);
        wait.until(ExpectedConditions.visibilityOf(userNameEle));
        String name=userNameEle.getText();

        return name;
    }

}
