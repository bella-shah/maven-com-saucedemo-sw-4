package com.saucedemo.testsuite;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends TestBase {
    LoginPage loginpage = new LoginPage();
    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce");
        loginpage.clickOnLoginBtn();
        String expectedErrorMessage = "PRODUCTS";
        String actualErrorMessage = loginpage.getproductMessage();
        org.testng.Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");


        }
        @Test
        public void verifyThatSixProductsAreDisplayedOnPage () {
            loginpage.enterUsername("standard_user");
            loginpage.enterPassword("secret_sauce");
            loginpage.clickOnLoginBtn();
            List<WebElement> products = driver.findElements(By.className("inventory_item"));
            System.out.println("Items displayed : " + products.size());
            for (WebElement element : products)
                Assert.assertEquals(true, element.isDisplayed());
        }
    }