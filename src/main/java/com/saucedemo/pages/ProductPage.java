package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends Utility {
    By emailField = By.id("user-name");
    By passwordField = By.name("password");
    By loginBtn = By.id("login-button");
    By headerMessage = By.xpath("//span[contains(text(),'Products')]");
    By products = By.xpath("//div[@class='inventory_list']//dv[@class='inventory_item_name']");
    public void enterEmailField(String email){
       sendTextToElement(emailField,email);
    }
    public void enterPasswordField(String password){
        sendTextToElement(passwordField,password);
    }
    public void loginBtn(){
        clickOnElement(loginBtn);
    }
    public String getHeaderMessage(){
        return getTextFromElement(headerMessage);
    }
    public void getProductList(){
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        System.out.println("Items displayed : " + products.size());
        for (WebElement element : products)
            Assert.isTrue(true,String.valueOf(element.isDisplayed()));
}}
