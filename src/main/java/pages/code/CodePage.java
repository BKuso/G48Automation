package pages.code;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

public class CodePage extends BaseProjectPage {

    private static final String title = "Стриница с исходным кодом проекта";

    public CodePage(WebDriver driver) {
        super(driver, title);
    }

    private final By commitMessageText = By.xpath("//a[@data-test-selector = 'commit-tease-commit-message']");

    @Step("Показываем сообщение коммита")
    public CodePage showCommitMessage(){
        LOG.info(driver.findElements(commitMessageText).get(0).getText());
        return this;
    }

}
