package Vytrack2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehicleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(12000);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void vehicleTest() throws InterruptedException {

        driver.findElement(By.linkText("Fleet")).click();
        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class = 'btn-group dropdown']")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("None")).click();
        System.out.println("None of the checkboxes are selected.");

        Thread.sleep(2000);

        driver.findElement(By.linkText("All")).click();
        System.out.println("All checkboxes are now selected.");
    }
}
