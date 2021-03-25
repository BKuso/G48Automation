package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNgTest {

    private String username;
    private String password;

    public TestNgTest(){}

    @Factory(dataProvider = "Our first data provider")
    public TestNgTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Test
    public void firstTest(){
        System.out.println("Username: " + this.username + ". Ignore me!");
    }


    @DataProvider(name = "Our first data provider")
    public Object[][] data(){
        return new Object[][]{
                {"adminUsername", "adminPassword"},
                {"testUsername", "testPassword"}
        } ;
    }

    @Test(testName = "Our TestNG first test",
          //  dataProvider = "Our first data provider",
            dependsOnMethods = "firstTest")
    public void someTest(){
        System.out.println("Login: " + this.username);
        System.out.println("Password: " + this.password);
    }


}
