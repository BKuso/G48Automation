package tests.ui;

import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static helpers.PropertyLoader.loadProperty;
import static java.lang.Integer.parseInt;

public abstract class BaseTest {

    protected RemoteWebDriver driver;

    @Rule
    public TestWatcher watcher = new TestWatcher() {

        @Attachment(value = "Failed screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenshotAsBytes){
            return screenshotAsBytes;
        }

        @Override
        protected void failed(Throwable e, Description description) {
            if (driver != null){
                saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
            super.failed(e, description);
        }

        /*
        @Override
      //  @Step("Закрываем драйвер после тестирования")
        protected void finished(Description description) {
            if (driver != null){
                driver.quit();
            }
        }

         */

    };

    @Before
    public void init(){
        String browserName = System.getProperty("browser", "chrome");

        if(System.getProperty("remote.launch", "true").equals("true")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browserName);
            capabilities.setCapability("version", System.getProperty("browser.version"));
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            try {
                this.driver = new RemoteWebDriver(new URL("http://172.17.0.1:4444/wd/hub"), capabilities);
            } catch (MalformedURLException ignored) {
            }
        } else {
            switch (browserName) {
                case "firefox" -> this.driver = new FirefoxDriver();
                case "opera" -> this.driver = new OperaDriver();
                default -> this.driver = new ChromeDriver();
            }
        }
        this.driver.manage().timeouts().implicitlyWait(
                parseInt(loadProperty("timeout.implicit")),
                TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(loadProperty("app.url"));
    }

    @After
    public void exit(){
        this.driver.quit();
    }


}
