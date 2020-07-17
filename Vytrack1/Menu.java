package Vytrack1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Menu {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(15000);
    }

    @AfterMethod
    public void afterMethod(){

        driver.quit();
    }

    @Test
    public void fleetOptions() throws InterruptedException {

        driver.findElement(By.linkText("Fleet")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(3000);

        String actualPageName = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedPageName = "Cars";
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedPageName, actualPageName);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void customersOptions() throws InterruptedException {

        driver.findElement(By.linkText("Customers")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Accounts")).click();
        Thread.sleep(3000);

        String expectedPageName = "Accounts";
        String actualPageName = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedTitle = "Accounts - Customers";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedPageName, actualPageName);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void customerContacts() throws InterruptedException {

        driver.findElement(By.linkText("Customers")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Contacts")).click();
        Thread.sleep(3000);

        String actualPageName = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedPageName = "Contacts";
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Contacts - Customers";

        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        Assert.assertEquals(expectedPageName,actualPageName);
    }

    @Test
    public void activitiesOptions() throws InterruptedException {

        driver.findElement(By.linkText("Activities")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(3000);

        String actualPageName = driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText();
        String expectedPageName = "Calendar - Events";
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Calendar Events - Activites";

        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        Assert.assertEquals(expectedPageName,actualPageName);
    }
}
