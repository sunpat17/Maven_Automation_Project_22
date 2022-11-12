package Day11_110522;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean_Yahoo {
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

        @AfterSuite
        public void quitTheSession() {
            driver.quit();
        }//end of after suite

        //Test case 1 should verify the total count of the display header
        @Test(priority = 1)
        public void verifyByDefaultOptionIsSignedIn() {
            //navigate to the website
            driver.navigate().to("https://www.yahoo.com");
            //click on the sign in button
            Reusable_Actions.clickAction(driver, "//*[@class= '_yb_1933e']", "Sign in button");
            //we need to verify that sign in option is checked
            boolean isSignedInCheckedIn = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
            System.out.println("The checkbox conditon is: " + isSignedInCheckedIn);

        }//end of test 1
}//end of class
