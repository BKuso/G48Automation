package tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static helpers.FileHelper.readFile;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class NegativeLoginTest extends BaseTest{

    private LoginPage loginPage;
    private final String username;
    private final String password;

    public NegativeLoginTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Parameterized.Parameters
    public static List<Object[]> data(){
        List<Object[]> result = new ArrayList<>();
        readFile(getProperty("user.dir") + "/src/test/resources/testData/negative_login_data.txt").forEach(line -> result.add(line.split(", ")));
        return result;
    }

    @Test
    public void checkNegativeLogin(){
        loginPage.login(this.username,this.password);
        loginPage.validateErrorMessage("Incorrect username or password.");
    }


}
