package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Tframework {
    public WebDriver driver;

    @BeforeSuite
    public void LaunchingtheBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     //   driver.get("https://magento.softwaretestingboard.com/customer/account/");
        driver.manage().window().maximize();
        System.out.println("this is launching page");

    }

    @BeforeClass
    //  lambda test
    public void lambdaapplication() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.merge(chromeOptions);
        driver = new RemoteWebDriver(new URL("https://yelurir4:vxAR3kltNQwEQnAh3nTsPe1exm3cYOvUvzYFJpwEHiEJnASwPn@hub.lambdatest.com/wd/hub"), chromeOptions);
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
        driver.manage().window().maximize();


    }
}


