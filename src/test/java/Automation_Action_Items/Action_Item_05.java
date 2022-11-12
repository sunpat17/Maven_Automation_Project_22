package Automation_Action_Items;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Action_Item_05 {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test()
    public void findDentist() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.UHC.com");
        //click on find a doctor
        Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");
        //wait
        //Thread.sleep(2000);
        //scroll to view find a doctor
        Reusable_Actions.scrollByView(driver, "//*[@id= 'main-content']", 0, "Main Content Header");
        ///Thread.sleep(2000);
        //click on find a dentist
        Reusable_Actions.clickAction(driver, "//*[text()= 'Find a dentist']", "Find a dentist");
        //wait
        //Thread.sleep(2000);
        //switch to new tab
        Reusable_Actions.switchToTab(driver, 1);
        // refresh the website
        //driver.navigate().refresh();
        //click on employer and individual plan
        Reusable_Actions.clickAction(driver,"//*[text()='Employer and Individual Plans']", "Employer and Individual Plans");
        //wait
        Thread.sleep(2000);
    }//end of test 1
    @Test(dependsOnMethods = "findDentist")
    public void zipCode() throws InterruptedException {
        //input zipcode
        Reusable_Actions.sendKeysAction(driver,"//*[@id= 'location']", "11550", "Zip Code" );
        // wait a sec
        Thread.sleep(2000);
        //click submit
        Reusable_Actions.clickAction(driver, "//*[@type='submit']","Submit");
        Thread.sleep(2000);
        //click on National Options
        Reusable_Actions.clickActionByIndex(driver,"//*[@class='sc-jomqko TEkcT']", 0,"National Options");
        //wait
        Thread.sleep(1000);
        // click on general dentist
        Reusable_Actions.clickAction(driver,"//*[@id='nodeDescription1']","general dentist");
        Thread.sleep(8000);
    }// end of test 2
    @Test(dependsOnMethods = "zipCode")
    public void menu() {
        //select a different mileage
        Reusable_Actions.selectByText(driver, "//*[@id='distance']", 0, "Within 50 Miles","miles dropdown on general dentist page ");
        //class="radiusMiles ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse ally-focus-within"
        //click on first doctor
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "First Doctor");
        //click on save button
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='saved-provider-button']", 0, "Save button");
        //capture address, miles, & network type
        String info = Reusable_Actions.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles, & Network Type");
        //print out information
        System.out.println(info);
        //close out the tab
        driver.close();
    }//test 3
    @Test(dependsOnMethods = "menu")
    public void doctor() throws InterruptedException {
        //switch back to default tab
        Reusable_Actions.switchToTab(driver, 0);
        //navigate back to website
        driver.navigate().to("https://www.uhc.com/");
        Thread.sleep(1000);
        //enter keyword doctor on the search field
        Reusable_Actions.sendKeysAction(driver, "//*[@id='search-desktop']", "Doctor", "Search Doctor");
        // click submit on the search
        Reusable_Actions.clickAction(driver, "//*[@id='search__button-desktop']", "submit icon");
        //capture search results
        String searchResult = Reusable_Actions.getTextAction(driver, "//*[@id='search-results-count__header']","Search Results");

        String[] arrayMessage = searchResult.split(" ");
        System.out.println(arrayMessage[0] + arrayMessage[1] + arrayMessage[2]);
    }// end of test 4

}//end of java class
