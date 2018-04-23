package Base;

import Utils.WebEventListner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Utils.TestUtil.IMPLICIT_WAIT;
import static Utils.TestUtil.PAGE_LOAD_TIMEOUT;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListner eventListner;

    public TestBase() {
        try {
            prop = new Properties();
            String file = "D:\\Training Videos\\Naveen\\todelete\\src\\main\\java\\Config\\config.properties";
            FileInputStream ip = new FileInputStream(file);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browsername = prop.getProperty("browser");
        if (browsername.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumJars\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        if (browsername.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\SeleniumJars\\Firefox and Gecko\\geckodriver.exe");
            WebDriver driver = new ChromeDriver();
        }
        e_driver = new EventFiringWebDriver(driver);
        // Now create eventlistner handler to register it with the Event Firing Webdriver.
        eventListner = new WebEventListner();
        e_driver.register(eventListner);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("URL"));
    }

}
