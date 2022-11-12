package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();
        //navigate to the google site
        driver.navigate().to("https://www.yahoo.com");
        //maximize my window
        //for windows
        driver.manage().window().maximize();
        //click on sign in
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //sleep statement
        Thread.sleep(2000);
        //navigate to the google site
        driver.navigate().to("https://www.yahoo.com");
        //sleep statement
        Thread.sleep(1000);
        //click on bell icon
        driver.findElement(By.xpath("//*[contains(@class, 'rapid-nonanchor')]")).click();
        //sleep statement
        Thread.sleep(2000);
        //quit chrome
        driver.quit();
    }//end of main
}//end java class
