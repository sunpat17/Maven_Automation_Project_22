package Day13_111122;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Reusable_Library.Reusable_Annotation.driver;
import static Reusable_Library.Reusable_Annotation.logger;

public class T1_yahooSrceenShot {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked(){
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        //this will fail because the xpath is incorrect(screenshot should be attached to the report)
        Reusable_Actions ReusableActions_Loggers;
        Reusable_Actions_Logger.clickAction(driver,"//*[@class = '_yb_1933eyyy']",logger,"Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1
}//end of java class

