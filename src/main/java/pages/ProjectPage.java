package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BaseAuthorizedPage{

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    private final By commitMessageText = By.xpath("//a[@data-test-selector = 'commit-tease-commit-message']");

    public ProjectPage showCommitMessage(){
        LOG.info(driver.findElements(commitMessageText).get(0).getText());
        return this;
    }

}
