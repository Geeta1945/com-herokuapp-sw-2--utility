package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility_package.Utility_Class;

public class LoginTest extends Utility_Class {


    @Before
    public void setUpHeroKuapp() {

        openBrowser_HeroKuapp(); // opening browser using BaseTest method and passing url as parameter
    }

    /*
    1. userSholdLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the text “Secure Area”


     */

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith");
        sendTextToElement(By.xpath("//input[@name='password']"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        Assert.assertEquals("Secure Area", getTextFromElement(By.xpath("//h2[normalize-space()='Secure Area']")));


    }
    /*
    2. verifyTheUsernameErrorMessage
* Enter “tomsmith1” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the error message “Your username
 is invalid!”

     */

    @Test
    public void verifyTheUsernameErrorMessage() {

        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith1");
        //finding username element and sending username information

        sendTextToElement(By.xpath("//input[@name='password']"), "SuperSecretPassword!");
        //finding password element and sending password information

        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // finding the login button and clicking that one
        String actualMessageDisplay = getTextFromElement(By.xpath("//div[@class='flash error']"));
        // retrieving error message from web page
        Assert.assertTrue("", actualMessageDisplay.contains("Your username is invalid!"));
        // checking that message retrieved from web contains "Your username is invalid!"

    }
    /*
    3. verifyThePasswordErrorMessage
* Enter “tomsmith” username
* Enter “SuperSecretPassword” password
* Click on ‘LOGIN’ button
* Verify the error message “Your password
 is invalid

     */

    @Test
    public void verifyThePasswordErrorMessage() {

        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith");
        //finding username element and sending username information
        sendTextToElement(By.xpath("//input[@name='password']"), "SuperSecretPassword");
        //finding password element and sending password information
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // finding the login button and clicking that one
        Assert.assertTrue("", getTextFromElement(By.id("flash")).contains("Your password is invalid!"));


    }

    @After

    public void closeBrowsers() {

        endProcedure();
    }


}
