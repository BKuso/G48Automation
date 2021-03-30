package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProjectPage;

import java.util.List;

public class IssueCreationPage extends BaseProjectPage {

    public IssueCreationPage(WebDriver driver) {
        super(driver);
    }

    private final By titleField = By.id("issue_title");
    private final By bodyField = By.id("issue_body");
    private final By submitButton = By.xpath("//button[contains(text(), 'Submit new issue')]");

    private final By labelsButton = By.id("labels-select-menu");
    private final By labelsList = By.xpath("//div[@class = 'css-truncate']");

    public IssueInfoPage createNewIssue(String title,
                                     String body,
                                     List<String> labels){
        driver.findElement(titleField).sendKeys(title);
        driver.findElement(bodyField).sendKeys(body);
        driver.findElement(labelsButton).click();
        List<WebElement> labelsOnPage = driver.findElements(labelsList);
/*
        for (WebElement labelOnPage: labelsOnPage){
            if(labels.contains(labelOnPage.getText())){
                labelOnPage.click();
            }
        }
 */
        labelsOnPage.stream()
                .filter(labelOnPage -> labels.contains(labelOnPage.getText()))
                .forEach(filteredLabelOnPage -> filteredLabelOnPage.click());

        driver.findElements(submitButton).get(0).click();
        driver.findElements(submitButton).get(0).click();

        return new IssueInfoPage(driver);
    }


}
