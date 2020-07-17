import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class WebDriverPractice {
    public static WebDriver driver;
    @BeforeMethod
    public static void setUp(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test
    public static void TestCase1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String result = driver.findElement(By.xpath("(//div[@class='col-sm-5']//small)[22]")).getText();
        Assert.assertEquals(result,"The date of birth is not valid");
    }

    @Test
    public static void TestCase2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox3")).isDisplayed());

    }

    @Test
    public static void TestCase3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        driver.findElement(By.name("firstname")).sendKeys("q");
        Assert.assertTrue(driver.findElement(By.xpath("(//small[@class='help-block'])[2]")).isDisplayed());
    }
    @Test
    public static void TestCase4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        driver.findElement(By.name("lastname")).sendKeys("q");
        Assert.assertTrue(driver.findElement(By.xpath("(//small[@class='help-block'])[6]")).isDisplayed());
    }
    @Test
    public static void testCase5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();


        driver.findElement(By.name("firstname")).sendKeys("Berlinda");
        driver.findElement(By.name("lastname")).sendKeys("Krasniqi");
        driver.findElement(By.name("username")).sendKeys("BerlindaK");
        driver.findElement(By.name("email")).sendKeys("berlinda@cybertekschool.com");
        driver.findElement(By.name("password")).sendKeys("Berlindak123");
        driver.findElement(By.name("phone")).sendKeys("123-456-7855");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("11/05/1995");
        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByValue("DE");
        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox1")).click();

        //Click Sign up
        driver.findElement(By.id("wooden_spoon")).click();

        //Verify that following success message is displayed: “You've successfully completed registration!”
        String success = driver.findElement(By.xpath("//div[@class='alert alert-success']//p")).getText();
        Assert.assertEquals(success,"You've successfully completed registration!");
    }
    @Test
    public static void testCase6(){

        driver.get("https://www.tempmailaddress.com");
        String tempEmail = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/sign_up'])")).click();
        driver.findElement(By.name("full_name")).sendKeys("Berlinda");
        driver.findElement(By.name("email")).sendKeys(tempEmail);
        driver.findElement(By.name("wooden_spoon")).click();

        Assert.assertTrue(driver.findElement(By.name("signup_message")).isDisplayed());

//      Navigate back to the “https://www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com");

//        Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        WebElement email = driver.findElement(By.xpath("//span[text()='do-not-reply@practice.cybertekschool.com']"));
        Assert.assertNotNull(email);

//       Click on that email to open it.
        WebElement emailRow = driver.findElement(By.xpath("//tbody/tr[1]"));
        Assert.assertNotNull(emailRow);
        emailRow.click();



        driver.findElement(By.xpath("//tbody[@id='schranka']//tr[@class='hidden-md hidden-lg klikaciRadek']")).click();
        String emailconfig = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(emailconfig,"do-not-reply@practice.cybertekschool.com");
//        String subject = driver.findElement(By.id("predmet")).getText();
//        Assert.assertEquals(subject,"Thanks for subscribing to practice.cybertekschool.com!");
//        String email = driver.findElement(By.xpath("//td[@class='from']")).getText();
//        String configEmail = " do-not-reply@practice.cybertekschool.com";
//        Assert.assertEquals(email,configEmail);
//        String subject = driver.findElement(By.xpath("//tr[@class='hidden-xs hidden-sm klikaciRadek']//td[2]")).getText();
//        Assert.assertEquals(subject,"Thanks for subscribing to practice.cybertekschool.com!");
    }

    @AfterMethod
    public static void closeDriver(){
        driver.close();
    }
}
