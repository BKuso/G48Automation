package pages.issues;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

public class IssuesPage extends BaseProjectPage {

    private static final String title = "Список задач";

    public IssuesPage(WebDriver driver) {
        super(driver, title);
    }

    private final By newIssueButton = By.xpath("//span[text() = 'New issue']");

    @Step("Нажимаем \"Создать\"")
    public IssueCreationPage openCreationPage(){
        LOG.info("Нажимается кнопка \"Создать новую задачу\"");
        driver.findElement(newIssueButton).click();
        return new IssueCreationPage(driver);
    }
}
