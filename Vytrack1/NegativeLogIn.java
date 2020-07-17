package Vytrack1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogIn {
    WebDriver driver;

    @Test
    public void negativeTest() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("hasdsajhd");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);

        String actualMessage = driver.findElement(By.xpath("//*[@class = 'alert alert-error']")).getText();
        String expectedMessage = "Invalid user name or password.";
        Assert.assertEquals(expectedMessage, actualMessage);

        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        if(currentTitle.equals(currentUrl)){
            System.out.println("Name of the web page is the same as the title.");
        }
        else{
            System.out.println("Name of the web page is different from the title");
            System.out.println("Title of the webpage: " + currentTitle);
            System.out.println("Url of the webpage: " + currentUrl);
        }
    }
}
