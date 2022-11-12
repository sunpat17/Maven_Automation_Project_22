package Automation_Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Action_Item_02 {
    public static void main(String[] args) throws InterruptedException {

        //ArrayList for sports
        ArrayList<String>  sports = new ArrayList<>();
        sports.add("Basketball");
        sports.add("Soccer");
        sports.add("Football");
        sports.add("Bowling");

        //define webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        for(int i=0; i<sports.size();i++) {

            //navigate to the Bing site
            driver.navigate().to("https://www.bing.com");
            //maximize the window for windows
            driver.manage().window().maximize();

            //sleep statement
            Thread.sleep(3000);

            //search a keyword on the search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            //hit submit on the bing search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("the search number is " + sports.get(i) + " is " + splitResult[0]);

        }//end of for loop
        //quit the driver to end the session
        driver.quit();
    }//end of main
}//end of java class


