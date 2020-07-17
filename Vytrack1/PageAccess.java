package Vytrack1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageAccess {
    WebDriver driver;

    @Test
    public void vehicleContractStoreManager() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(15000);

        driver.findElement(By.linkText("Fleet")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicle Contracts")).click();

        Thread.sleep(3000);

        String pageTitle = driver.getTitle();
        System.out.println("As Store Manager, I am able to access " + pageTitle);
    }

    @Test
    public void vehicleContractSalesManager() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(15000);

        driver.findElement(By.linkText("Fleet")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicle Contracts")).click();

        Thread.sleep(3000);

        String pageTitle = driver.getTitle();
        System.out.println("As Sales Manager, I am able to access " + pageTitle);
    }

    @Test
    public void vehicleContractsAsDriver() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(15000);

        driver.findElement(By.xpath("//*[@class = 'close']")).click();

        driver.findElement(By.linkText("Fleet")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicle Contracts")).click();

        Thread.sleep(5000);

        String alertMessage = driver.findElement(By.xpath("//*[@class = 'message']")).getText();
        System.out.println("Message that we got after clicking on 'Vehicle Contracts': " + alertMessage);
    }
}
