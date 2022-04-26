package utility_package;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility_Class extends BaseTest {
    public void clickOnElement(By by) {
        // find log in link and click on login link

        driver.findElement(by).click();
    }

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();

    }


    public void sendTextToElement(By by,String str)
    {
        driver.findElement(by).sendKeys(str);
    }


}
