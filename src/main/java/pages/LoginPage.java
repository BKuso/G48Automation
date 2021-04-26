package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends BasePage {

    private static final String title = "Страница авторизации";

    private final By loginField = By.name("login");
    private final By passwordField = By.name("password");
    private final By submitButton = By.name("commit");
    private final By errorMessageText = By.xpath("//div[@class = 'flash flash-full flash-error ']/div");

    public LoginPage(WebDriver driver) {
        super(driver, title);
    }

    @Step("Производится авторизация")
    public MainPage login(String username, String password){
        LOG.info("Производится авторизация...");
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new MainPage(driver);
    }

    @Step("Валидируем сообщение об ошибке")
    public LoginPage validateErrorMessage(String errorMessage){
        waitFor25.until(visibilityOf(driver.findElement(errorMessageText)));
        Assert.assertEquals(errorMessage, driver.findElement(errorMessageText).getText());
        return this;
    }

}
