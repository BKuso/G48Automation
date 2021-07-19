package pages;

import annotations.SpiraTestStep;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseAuthorizedPage extends BasePage{

    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private final By userProfileButton = By.xpath("//summary[@aria-label='View profile and more']");
    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign')]");

    @Step("Выходим из приложения")
    @SpiraTestStep(id = 5)
    public HomePage logout(){
        LOG.info("Выход из приложения");
        driver.findElement(userProfileButton).click();
        waitFor10.until(ExpectedConditions.visibilityOf(driver.findElement(logOutButton))).click();
        LOG.info("Выход успешен");
        return new HomePage(driver);
    }


}
