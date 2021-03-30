package tests.testNg;

//import org.testng.annotations.Test;

public class TestNgTest {


   /* @Factory(dataProvider = "Our first data provider",
          dataProviderClass = TestNgProviders.class)
    public TestNgTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    */


/*
    @Test(testName = "Our TestNG first test",
            dataProviderClass = TestNgProviders.class,
            dataProvider = "Our first data provider")

 */
    public void someTest(String username, String password){
        System.out.println("Login: " + username);
        System.out.println("Password: " + password);
    }


}
