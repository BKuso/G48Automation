package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.CodePage;
import pages.issues.IssuesPage;

public abstract class BaseProjectPage extends BaseAuthorizedPage{

    public BaseProjectPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private final By codeTab = By.xpath("//span[@data-content = 'Code']");
    private final By issuesTab = By.xpath("//span[@data-content = 'Issues']");


    //todo Дописать сюда нужные вкладки
    //........
    private final By settingsTab = By.xpath("//span[@data-content = 'Settings']");

    public CodePage openSourceCode(){
        driver.findElement(codeTab).click();
        return new CodePage(driver);
    }

    @Step("Открываем вкладку \"Issues\"")
    public IssuesPage openIssues(){
        LOG.info("Открыватся вкладка задач проекта");
        driver.findElement(issuesTab).click();
        LOG.info("Успешно");
        return new IssuesPage(driver);
    }


}
