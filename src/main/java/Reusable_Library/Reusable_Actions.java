package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {
    static int timeout = 8;



    //reuseable method to define and launch webdriver
    public static WebDriver setUpDriver(){
        //set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        options.addArguments("start-maximized");
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //return driver
        return driver;
    }//end of setUpDriver method


    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of clickAction method


    public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of clickActionByIndex method


    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of mouseHover method


    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
        }//end of catch
    }//end of sendKeysAction method


    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
        }//end of catch
        return textOutput;
    }//end of getTextAction method


    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of submit action

    public static void selectByText(WebDriver driver, String xpath,int index, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            ArrayList<WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            Select dropDown = new Select(element.get(index));
            dropDown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Unable to selectByVisibleText on element: " + elementName + " for reason: " + e);
        }
    }//end of select by visible text action


    public static void switchToTab(WebDriver driver, int tabIndex) {
        //store the tabs in arrayList
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));

    }//end of switchTab command

    public static void scrollByView(WebDriver driver, String xpath, int scrollIndex, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            ArrayList<WebElement> scrollElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            //scroll into view of calculate button
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement.get(scrollIndex));
        } catch (Exception e){
            System.out.println("Unable to scroll by view: " + elementName + "for reason: " + e);
        }//end of catch
    }//end scroll By View


}//end of java class
