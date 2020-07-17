import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        navigateChrome();
        navigateFirefox();
    }
   public static void navigateChrome(){
       WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("https://google.com");
       String googleTitle =driver.getTitle();

       driver.get("https://etsy.com");
       String etsyTitle = driver.getTitle();
        driver.navigate().back();

        String actualGoogleTitle = driver.getTitle();
       StringUtility.verifyEquals(googleTitle, actualGoogleTitle);

       driver.navigate().forward();
       String actualEtsyTitle = driver.getTitle();
       StringUtility.verifyEquals(etsyTitle, actualEtsyTitle);

   }

    public static void navigateFirefox(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String googleTitle =driver.getTitle();

        driver.get("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();

        String actualGoogleTitle = driver.getTitle();
        StringUtility.verifyEquals(googleTitle, actualGoogleTitle);

        driver.navigate().forward();
        String actualEtsyTitle = driver.getTitle();
        StringUtility.verifyEquals(etsyTitle, actualEtsyTitle);

    }

}
