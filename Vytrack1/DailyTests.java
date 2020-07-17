package Vytrack1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyTests {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(12000);
    }

    @AfterMethod
    public void closeUpMethod(){
        driver.quit();
    }

    @Test
    public void dailyRepeatOption() throws InterruptedException {
        driver.findElement(By.linkText("Activities")).click();
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class = 'btn main-group btn-primary pull-right ']")).click();
        Thread.sleep(8000);

        driver.findElement(By.cssSelector("input[id^='recurrence-repeat-view']")).click();

        Select select = new Select(driver.findElement(By.cssSelector("select[id^='recurrence-repeats-view']")));

        List<WebElement> options = select.getOptions();
        List<String> expected = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actual = new ArrayList<>();

        for(WebElement option: options){
            actual.add(option.getText());
        }

        Assert.assertEquals(expected, actual);

        System.out.println("Days checkbox is selected: " + driver.findElement(By.xpath("//*[@class = 'recurrence-subview-control__item']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//*[@class = 'control-group recurrence-summary alert-info']")).getText());
        driver.findElement(By.xpath("//*[. = 'Weekday']")).click();
        Thread.sleep(2000);
        System.out.println("Days input is selected now: " + driver.findElement(By.xpath("//*[@class = 'recurrence-subview-control__number']")).isSelected());

        System.out.println(driver.findElement(By.xpath("//*[@class = 'control-group recurrence-summary alert-info']")).getText());
    }
}
