package Vytrack1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DateTimeTests {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(10000);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void dateAndTime() throws InterruptedException {

        driver.findElement(By.linkText("Activities")).click();
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class = 'btn main-group btn-primary pull-right ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = 'input-small datepicker-input start hasDatepicker']")).click();
        driver.findElement(By.linkText("15")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class = 'input-small datepicker-input end hasDatepicker']")).click();
        String endDateText = driver.findElement(By.xpath("//*[@class = '  ui-datepicker-current-day']")).getText();
        System.out.println("End date text is: " + endDateText);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = '  ui-datepicker-current-day']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = 'input-small datepicker-input start hasDatepicker']")).click();
        driver.findElement(By.xpath("//*[@class = 'ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")).click();
    }

    @Test
    public void autoAdjustTime() throws InterruptedException {
        driver.findElement(By.linkText("Activities")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@class = 'btn main-group btn-primary pull-right ']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class = 'input-small timepicker-input start ui-timepicker-input']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(), '8:00 AM')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class = 'input-small timepicker-input end ui-timepicker-input']"));

        String timeSelected = driver.findElement(By.xpath("//*[@class = 'ui-timepicker-am ui-timepicker-selected']")).getText();

        System.out.println("Time change verification -> End time now: " + timeSelected);
    }
}