package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void browserSetUp(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //Launch driver
        driver.get(baseUrl);
        //Maximise screen
        driver.manage().window().maximize();
        //give implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        //driver.quit();
    }

}
