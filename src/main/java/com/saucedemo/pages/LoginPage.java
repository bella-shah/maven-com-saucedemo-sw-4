package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By productMessage = By.xpath("//span[contains(text(),'Products')]");


    public void enterUsername(String uname) {
        sendTextToElement(username,uname);
    }

    public void enterPassword(String pword) {
        sendTextToElement(password,pword);
    }
    public String getproductMessage(){
        return getTextFromElement(productMessage);
    }
    public void clickOnLoginBtn(){
        clickOnElement(loginBtn);
    }
}
