package pages;

import annotations.SpiraTestStep;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.CodePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainPage extends BaseAuthorizedPage{

    private static final String title = "Основная страница приложения";

    public MainPage(WebDriver driver) {
        super(driver, title);
    }

    private final By repositoryLink = By.xpath("//span[@title = 'G48Automation']");

    @Step("Открываем проект G48Automation")
    @SpiraTestStep(id = 3)
    public CodePage openProjectG48(){
        LOG.info("Открывается страница проекта G48Automation");
        waitFor25.until(elementToBeClickable(repositoryLink)).click();
        LOG.info("Успешно");
        return new CodePage(driver);
    }


}
