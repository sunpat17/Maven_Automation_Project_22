package Automation_Action_Items;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Logger;
import Reusable_Library.Reusable_Annotation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static Reusable_Library.Reusable_Annotation.logger;

public class Action_Item_06 extends Reusable_Annotation {

    @Test()
    public void CheckingInfo () throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.capitalone.com/");
        //hover over Checkings & Saving
        Reusable_Actions_Logger.mouseHover(driver, "//*[@id='bank']", logger, "Checking & Savings");
        //click on 360 checking
        Reusable_Actions_Logger.clickAction(driver, "//*[@class= 'site-L2__tabbable']", logger,"360 Checking");
        //wait
        Thread.sleep(3000);
        //declare Java script to scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down 300 pixels
        jse.executeScript("300");
        //capture the six headers for 360 checking



    }//end of test 1
}//end of java class
