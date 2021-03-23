package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseAuthorizedPage extends BasePage{

    public BaseAuthorizedPage(WebDriver driver) {
        super(driver);
    }

    private final By userProfileButton = By.xpath("//summary[@aria-label='View profile and more']");
    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign')]");

    public HomePage logout(){
        driver.findElement(userProfileButton).click();
        waitFor10.until(ExpectedConditions.visibilityOf(driver.findElement(logOutButton))).click();
        return new HomePage(driver);
    }


}
