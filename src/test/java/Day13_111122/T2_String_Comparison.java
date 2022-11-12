package Day13_111122;

import Reusable_Library.Reusable_Actions_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import static Reusable_Library.Reusable_Annotation.driver;
import static Reusable_Library.Reusable_Annotation.logger;

public class T2_String_Comparison {
    @Test(priority = 1)
    public void tc001_verifyYahooPageTitle() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String expectedTitle = "Yahoo..";
        //get page title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            logger.log(LogStatus.PASS, "Expected Result matches Actual Result");
        } else {
            logger.log(LogStatus.FAIL, "Expected Result does not match Actual Result");
        }
    }//end of test 1

    @Test(priority = 2)
    public void tc002_verifyYahooSignInText() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String actualYahooSignInButtonText = Reusable_Actions_Logger.getTextAction(driver, "//*[@class = '_yb_18vjf']", logger, "Sign In");
        //define expected string text
        String expectedYahooSignInButtonText = "Sign In";
        Reusable_Actions_Logger.compareExpectedAndActualText(expectedYahooSignInButtonText, actualYahooSignInButtonText,logger);
    }//end of test 2

}//end of java class
