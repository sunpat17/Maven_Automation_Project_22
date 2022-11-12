package Day11_110522;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_WebElement_List {
    WebDriver driver;
    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setUpDriver();
        driver.navigate().to("https://www.usps.com");
        //store all the menu headers into an arrayList Webelement
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'nav-list']/li")));
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    //Test case 1 should verify the total count of the display header
    @Test(priority = 1)
    public void verifyTotalCountOfMenuHeader(){
        System.out.println("The total number of of menu header is:" + totalMenuHeaders.size());
    }//end of test 1

    //click on the first header
    @Test(priority = 2)
    public void clickOnFirstHeader(){
    totalMenuHeaders.get(0).click();
    }//end of test 2

    @Test(priority = 3)
    public void verifyMainMenuHeader(){
        mainMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'menuheader']")));
        System.out.println("The total number of main menu header is:" + mainMenuHeaders.size());
    }//end of test 3


}//end of java class
