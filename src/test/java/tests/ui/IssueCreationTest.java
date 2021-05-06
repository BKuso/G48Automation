package tests.ui;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static helpers.ExcelHelper.readDataProviderFromExcel;
import static java.lang.System.getProperty;

@Story("Positive")
@Feature("Github Issue Creation")
@Owner("BKuso")
@Severity(SeverityLevel.CRITICAL)
@RunWith(Parameterized.class)
public class IssueCreationTest extends BaseTest{

    private final String title;
    private final String body;
    private final List<String> labels;

    private  LoginPage page;

    public IssueCreationTest(String title,
                             String body,
                             List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static List<Object[]> data(){
        return readDataProviderFromExcel(
                System.getProperty("user.dir") + "/src/test/resources/testData/excel_out.xls",
                "Sheet1");
    }

    @Before
    public void prepareData(){
        this.page = new LoginPage(this.driver);
    }

    @Description("Тест нужен для создания проблемы в проекте")
    @DisplayName("Завести проблему в проекте")
    @Test
    public void checkIssueCreation(){
        this.page.login(getProperty("username"), getProperty("password"))
                .openProjectG48()
                .openIssues()
                .openCreationPage()
                .createNewIssue(
                        this.title,
                        this.body,
                        this.labels)
                .validateIssue(
                        this.title,
                        this.body,
                        this.labels)
                .logout();

    }


}
