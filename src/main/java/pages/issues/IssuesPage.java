package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

public class IssuesPage extends BaseProjectPage {

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    private final By newIssueButton = By.xpath("//span[text() = 'New issue']");

    public IssueCreationPage openCreationPage(){
        driver.findElement(newIssueButton).click();
        return new IssueCreationPage(driver);
    }
}
