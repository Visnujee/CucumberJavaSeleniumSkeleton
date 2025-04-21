package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver(){
        if (driver == null) {
            System.out.println("Initializing ChromeDriver...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            System.out.println("ChromeDriver already initialized.");
        }
    }

    public static void close(){
        if (driver != null) {
            System.out.println("Closing the browser..."); // Debugging statement
            driver.quit();  // Use quit for full cleanup (terminates the session)
            driver = null;
        } else {
            System.out.println("Driver is already null, nothing to close."); // Debugging statement
        }
    }

}
