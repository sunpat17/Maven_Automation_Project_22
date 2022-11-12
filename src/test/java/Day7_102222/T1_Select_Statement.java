package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add the options
        options.addArguments("start-maximized", "incognito");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc
        driver.navigate().to("http://www.mlcalc.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()= 'Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name= 'sm']"));
        Select startMonthDropDown = new Select(strtMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");

        //use select command for year dropdown
        //WebElement strtYear = driver.findElement(By.xpath("//*[@name= 'sy']"));
        //Select startYearDropDown = new Select(strtYear);
        //select using visible text
        //startYearDropDown.selectByVisibleText("2023");

        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();

    }//end of main
}//end of java class
