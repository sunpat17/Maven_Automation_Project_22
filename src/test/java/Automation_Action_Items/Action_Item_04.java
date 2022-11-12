package Automation_Action_Items;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Action_Item_04 {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        options.addArguments("start-maximized");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //create array list for destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("North Dakota");
        destinations.add("Colorado");
        destinations.add("Tennessee");

        //create an arraylist for adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);

        //create an arraylist for children age
        ArrayList<String> Age = new ArrayList<>();
        Age.add("1");
        Age.add("2");
        Age.add("3");

        //create for loop to iterate through destinations
        for (int i=0; i < destinations.size(); i++) {


            try {
                //navigate to hotels.com
                driver.navigate().to("https://www.hotels.com");
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }//end of catch

            // wait 3 sec
            Thread.sleep(3000);


            try {
                // click on search bar "Going to"
                driver.findElement(By.xpath("//*[@class= 'uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }//end of catch


            try {
                // type in destination
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destinations.get(i));
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to type in destinations.. " + e);
            }//end of catch

            //added sleep time to adjust dates to get available dates manually
            Thread.sleep(10000);


            try {
                // click on travelers
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers.. " + e);
            }//end of catch

            // wait a sec
            Thread.sleep(1000);

            //create an arraylist
            ArrayList<WebElement> plusMinus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));


            try {
                //click to add one child
                plusMinus.get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on + to add a child.. " + e);
            }//end of catch

            //create for loop for adults age
            for (int j = 1; j < adults.get(i); j++) {

                try {
                    // add adults age
                    plusMinus.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to add adults age.. " + e);
                }//end of catch

            }// end of adults loop


            try {
                //click to add one child
                plusMinus.get(3).click();
            } catch (Exception e) {
                System.out.println("Unable to add one child.. " + e);
            }//end of catch

            //use select command for children
            WebElement child = driver.findElement(By.xpath("//*[@id= 'age-traveler_selector_children_age_selector-0-0']"));
            Select childDropDown = new Select(child);


            try {
                //select by value
                childDropDown.selectByValue(Age.get(i));
            } catch (Exception e) {
                System.out.println("Unable to select value.. " + e);
            }//end of catch


            try {
                //click done
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click done.. " + e);
            }//end of catch


            try {
                //click on the search button
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on the search button.. " + e);
            }//end of catch

            // wait a couple seconds
            Thread.sleep(3000);

            //create an arraylist for hotels
            ArrayList<WebElement> hotel = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'uitk-spacing uitk-spacing-margin-blockstart-three']")));
            //click on first hotel address
            if (i == 0) {
                try {
                    hotel.get(0).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on first link..." + e);
                }//end of catch
            } else if (i == 1) {
                try {
                    hotel.get(2).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on third link..." + e);
                }//end of catch
            } else if (i == 2) {
                try {
                    hotel.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on second link..." + e);
                }//end of catch
            }//end of 3rd if statement

            // capture all tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            // switch to new tabs
            driver.switchTo().window(tabs.get(1));

            //wait 8 seconds
            Thread.sleep(8000);


            try {
                // capture name of the hotel
                String hotelName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                //print out hotel name
                System.out.println(hotelName);
            } catch (Exception e) {
                System.out.println("Unable to print out hotel name...." + e);
            }//end of catch

            try {
                //click on reserve
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }//end of catch

            // wait a sec
            Thread.sleep(2000);


            try {
                //capture price of hotel
                String prices = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                // print out price of hotel
                System.out.println(prices);
            } catch (Exception e) {
                System.out.println("Unable to capture the price of the hotel.." + e);
            }//end of catch


            try {
                //click on reserve now
                driver.findElements(By.xpath("//*[@data-stid= 'submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }//end of catch

            // wait a sec
            Thread.sleep(4000);

            try {
                //capture dates
                String dates = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                //print out dates
                System.out.println(dates);
            } catch (Exception e) {
                System.out.println("Unable to capture and print out dates.." + e);
            }//end of catch

            //close tab
            driver.close();

            //switch back to orignal tab
            driver.switchTo().window(tabs.get(0));



        }//end of destinations loop

        //exit the driver
        driver.quit();


    }// end of main
}//end of java class
