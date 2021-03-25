package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class SomeTest {

    private String username;
    private String password;

    public SomeTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Parameterized.Parameters
    public static List<String[]> data(){
        List<String[]> result = new ArrayList<>();
        result.add(new String[]{"adminUser", "adminPassword"});
        result.add(new String[]{"testUser", "testPassword"});
        return result;
    }

    @Test
    public void showUsernameAndPassword(){
        System.out.println("Login: " + this.username);
        System.out.println("Password: " + this.password);
    }

}
