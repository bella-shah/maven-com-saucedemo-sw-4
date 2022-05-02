package com.saucedemo.utility;

import com.saucedemo.driverfactory.ManageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class Utility extends ManageDriver {
    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        // OR
        driver.findElement(by).click();
    }
    //This method will get text from element

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // This method will send text to element

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method will calculate size of List<WebElement>
    public int sizeOfListWebElement(By by) {
        List<WebElement> inventory = driver.findElements(by);
        int actualItems = inventory.size();
        return actualItems;
    }

    //This method will clear the text box
    public void clearTheTextBox(By by) {
        driver.findElement(by).clear();
    }

    //**************************************Alerts Methods***********************************//
    //this method is switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //this method is accepting the method
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method is for dismiss Alerts
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // This method is for get text from Alerts
    public String getTextAlert() {
        return driver.switchTo().alert().getText();

    }

    // This method is for send text to Alerts
    public void sendTextAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //------------------------------------------------select class methods ----------------------------//
    //sect by value, index ,visible text//This method will select the option by visible text

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown1(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropDown);
        select.selectByValue(text);
    }

    //OR//
    public void selectByValueFromDropDown(By by, String value) {
        new org.openqa.selenium.support.ui.Select(driver.findElement(by)).selectByValue(value);
    }


    public void selectByIndexFromDropDown1(By by, int indexNo) {
        WebElement dropDown = driver.findElement(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropDown);
        select.selectByIndex(indexNo);
    }

    //OR//
    public void selectByIndexFromDropDown(By by, int index) {
        new org.openqa.selenium.support.ui.Select(driver.findElement(by)).selectByIndex(index);
    }

    //This method will select all options & choose 1 from all
    public void selectByAllOptions(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        //System.out.println("No. of Options:" + allOptions.size());
        for (WebElement element : allOptions) {
            System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
            }
        }
    }
    //OR//
    //**************This method will select the option by contains text*******************************************//

    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }

        }
    }

    //***********************************************Switch Window Method*****************************************//
    //This method is for switching to iFrame
    public void switchIframe(By by, WebElement frameID, String text) {
        driver.switchTo().frame(frameID);
        sendTextToElement(by, text);
        driver.switchTo().defaultContent();
    }
    //This method will close all windows

    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    // This method will switch to parent window
    public void getParentWindowHandle(String parentWindow) {
        parentWindow = driver.getWindowHandle();
    }
    //OR//
    // This method will switch to parent window

    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    // This method is back to the Parent window
    public void getBackToParentWindow(String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

    // This method for get child window
    public void getChildWindowHandles(String parentWindow) {
        parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for (String handle : handles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                clickOnElement(By.xpath("//a[contains(text(),'Sign In')]"));
                driver.close();
                break;
            }
        }
    }
    // This method will find that we switch to right window

    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
    //****************************************Action Class Mouse perform Method***********************//

    public void mouseHoverClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
    public void mouseHoverOnly(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).build().perform();
    }
    //This method will be used to hover mouse on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    //This method will be used to hover mouse on element & click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    //*******************************************Click method for top Menu*****************************************//
    // this method click  on the menu whatever name is pass as a parameter
    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    //*********************Time stamp Method for Email Code(no need to change the email or registration)***********//
    //*************************************************Select Radio button Method *********************************//
    public void setRadioElement(By by) {
        WebElement radioElement = driver.findElement(by);
        boolean selectState = radioElement.isSelected();
        if (selectState == false) {
            radioElement.click();
        }
        //***************************************************Random Email Method ************************************//
    }

    public WebElement randomEmail1(By by) {
        WebElement emailtxt = driver.findElement(by);
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailtxt.sendKeys("Shah" + randomInt + "@gmail.com");
        return emailtxt;

    }
    //*************************************************Waits Methods *********************************************//
    //This method will use to wait until  VisibilityOfElementLocated

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //This method is for FluentWait

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

}


