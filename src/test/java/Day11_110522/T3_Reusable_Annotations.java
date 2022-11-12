package Day11_110522;

import Reusable_Library.Reusable_Actions_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T3_Reusable_Annotations {

    WebDriver driver;
    ExtentTest logger;
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        Reusable_Actions_Logger.clickAction(driver, "//*[@class = '_yb_1933e']", logger,"Sign in button");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test 1

    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click on check box to uncheck it
        Reusable_Actions_Logger.clickAction(driver, "//*[@class= 'stay-signed-in checkbox-container']", logger,"SignedInCheckBox");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test 2

}//end of java class
