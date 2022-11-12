package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Actions_Logger {
    static int timeout = 8;

    ExtentTest logger;


    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "" + elementName);
        }//end of catch
    }//end of clickAction method


    public static void clickActionByIndex(WebDriver driver, String xpath, int index,ExtentTest logger,  String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on element by index" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element by index: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element by index" + elementName);
        }//end of catch
    }//end of clickActionByIndex method


    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully able to hover to element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to hover to element" + elementName);
        }//end of catch
    }//end of mouseHover method


    public static void sendKeysAction(WebDriver driver, String xpath, String userInput,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully able to send keys to" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to" + elementName);
        }//end of catch
    }//end of sendKeysAction method


    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully able to get text for " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text for" + elementName);
        }//end of catch
        return textOutput;
    }//end of getTextAction method


    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully able to submit on element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element" + elementName);
        }//end of catch
    }//end of submit action

    public static void selectByText(WebDriver driver, String xpath,int index, String visibleText, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            ArrayList<WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            Select dropDown = new Select(element.get(index));
            dropDown.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS, "Successfully able to selectByVisibleText on element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to selectByVisibleText on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to selectByVisibleText on element" + elementName);
        }//end of catch
    }//end of select by visible text action

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText
}//end of java class
