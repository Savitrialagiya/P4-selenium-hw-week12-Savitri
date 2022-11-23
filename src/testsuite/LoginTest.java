package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = " https://www.saucedemo.com/";

    @Before
    public void setBaseUrl(){
        browserSetUp(baseUrl);
    }
    @Test
    public void  userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.name("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “PRODUCTS”
        //Expected Text
        String expectedText = "PRODUCTS";
        //Find Element and get text
       String actualText = getTextFromElement(By.xpath("//span[@class=\"title\"]"));
        //Verify actual and expected text
        Assert.assertEquals(expectedText,actualText);
    }
    
 @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
     sendTextToElement(By.id("user-name"),"standard_user");
     //Enter “secret_sauce” password
     sendTextToElement(By.name("password"),"secret_sauce");
     ////Click on ‘LOGIN’ button
     clickOnElement(By.id("login-button"));
     //Verify that six products are displayed on page

     int expectedNumber = 6;
     List<WebElement> list = driver.findElements(By.className("inventory_item"));
     int actualNumber = list.size();
     System.out.println("Number of products per page: " + actualNumber);
     Assert.assertEquals(expectedNumber,actualNumber);
 }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
