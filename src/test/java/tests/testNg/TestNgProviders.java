package tests.testNg;

//import org.testng.annotations.DataProvider;

public class TestNgProviders {

   // @DataProvider(name = "Our first data provider")
    public Object[][] data(){
        return new Object[][]{
                {"adminUsername", "adminPassword"},
                {"testUsername", "testPassword"}
        } ;
    }

}
