package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseProjectPage;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class IssueCreationPage extends BaseProjectPage {

    private static final String title = "Страница создания задачи";

    public IssueCreationPage(WebDriver driver) {
        super(driver, title);
    }

    private final By titleField = By.id("issue_title");
    private final By bodyField = By.id("issue_body");
    private final By submitButton = By.xpath("//button[contains(text(), 'Submit new issue')]");

    private final By labelsButton = By.id("labels-select-menu");
    private final By labelsList = By.xpath("//div[@class = 'css-truncate']/span");

    public IssueInfoPage createNewIssue(String title,
                                     String body,
                                     List<String> labels){
        LOG.info(String.format("Создаю задачу \"%s\" с телом \"%s\" и тегами \"%s\"", title, body, labels));
        driver.findElement(titleField).sendKeys(title);
        driver.findElement(bodyField).sendKeys(body);
        driver.findElement(labelsButton).click();
        List<WebElement> labelsOnPage = waitFor10.until(visibilityOfAllElements(driver.findElements(labelsList)));
        labelsOnPage.stream()
                .filter(labelOnPage -> labels.contains(labelOnPage.getText()))
                .forEach(WebElement::click);
        driver.findElement(labelsButton).click();
        driver.findElements(submitButton).get(0).click();
        LOG.info("Успешно");
        return new IssueInfoPage(driver);
    }


}
