package tests.ui;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void init(){
        String browserName = System.getProperty("browser", "chrome");
        switch (browserName){
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            case "opera":
                this.driver = new OperaDriver();
                break;
            default:
                this.driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
    }

    @After
    public void exit(){
        driver.quit();
    }


}
