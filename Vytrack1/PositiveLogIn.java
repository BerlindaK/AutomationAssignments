package Vytrack1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLogIn {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(15000);
    }

    @AfterMethod
    public void afterMethod(){

        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {

        String expectedNameStore = "Geovany Jenkins";
        String actualNameStore = driver.findElement(By.id("user-menu")).getText();
        Assert.assertEquals(expectedNameStore, actualNameStore);

        String actualPageStore = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedPageStore = "Dashboard";
        Assert.assertEquals(expectedPageStore, actualPageStore);

        Thread.sleep(10000);

        driver.findElement(By.className("fa-caret-down")).click();
        driver.findElement(By.className("no-hash")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(15000);

        String actualPageSales = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedPageSales = "Dashboard";
        Assert.assertEquals(expectedPageSales, actualPageSales);
        String actualNameSales = driver.findElement(By.id("user-menu")).getText();
        System.out.println("Name before was " + actualNameStore + ". And the name now is " + actualNameSales);

        Thread.sleep(10000);

        driver.findElement(By.className("fa-caret-down")).click();
        driver.findElement(By.className("no-hash")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(15000);

        String actualPageDriver = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedPageDriver = "Quick Launchpad";
        Assert.assertEquals(expectedPageDriver, actualPageDriver);

        System.out.println("Name before was " + actualNameSales + ". And the name now is " +
                driver.findElement(By.id("user-menu")).getText());
    }
}
