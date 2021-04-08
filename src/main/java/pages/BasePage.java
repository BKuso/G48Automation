package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final Logger LOG;

    protected WebDriver driver;
    protected WebDriverWait waitFor10;
    protected WebDriverWait waitFor25;

    public BasePage(WebDriver driver, String title){
        this.LOG = LogManager.getLogger(title);
        this.driver = driver;
        this.waitFor10 = new WebDriverWait(this.driver, 10);
        this.waitFor25 = new WebDriverWait(this.driver, 25);
    }

}
