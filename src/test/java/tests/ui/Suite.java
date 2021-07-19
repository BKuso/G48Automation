package tests.ui;


import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses(
        {
        LoginPageTest.class,
        IssueCreationTest.class
        }
)
public class Suite {
}
