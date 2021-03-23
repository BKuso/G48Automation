package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By homePageTitle = By.xpath("//h1");

    public void checkIsLogOut(){
        waitFor25.until(ExpectedConditions.visibilityOf(driver.findElement(homePageTitle)));
    }

}
