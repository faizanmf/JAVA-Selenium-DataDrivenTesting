package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    public void initialize()
    {
        prop = ConfigReader.initProperties();
       String browser = prop.getProperty("browser");

       if(browser.equalsIgnoreCase("chrome"))
       {
           driver = new ChromeDriver();

       }

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get(prop.getProperty("baseUrl"));
    }

    public void teardown()
    {

            driver.quit();

    }
}
