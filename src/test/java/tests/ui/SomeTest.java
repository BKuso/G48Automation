package tests.ui;

import org.javalite.activejdbc.DB;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static helpers.DbHelper.executeQuery;
import static helpers.ExcelHelper.*;

public class SomeTest {

    @Test
    public void some(){
       // readFile("/home/bohdan/opensource/G48Automation/src/test/resources/test").forEach(System.out::println);
        List<String> data = new ArrayList<>();
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");

        String newString = data.get(6) + " и точка!";

        data.add(newString);

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("1", "Я буду хорошим автоматизатором на Selenium");
        dataMap.put("2", "Я буду хорошим автоматизатором на Selenium");
        dataMap.put("3", "Я буду хорошим автоматизатором на Selenium");
        dataMap.put("4", "Я буду хорошим автоматизатором на Selenium");
        dataMap.put("5", "Я буду хорошим автоматизатором на Selenium");
        dataMap.put("6", "Я буду хорошим автоматизатором на Selenium");
        dataMap.put("7", "Я буду хорошим автоматизатором на Selenium");

        String newStringForMap = dataMap.get("6") + " и точка!";

        dataMap.put("6", newStringForMap);

        System.out.println(dataMap);

      //  readFile(writeFileAndGet(data, "our_test.txt")).forEach(System.out::println);
    }

   // @Test
    public void someExcel(){
        readDataFromExcelFile(
                writeToExcelFileAndGet(
                    "/home/bohdan/opensource/G48Automation/target/outputFiles/outputExcel.xls",
                            readDataFromExcelFile(
                            "/home/bohdan/opensource/G48Automation/src/test/resources/testData/excel_out.xls",
                        "Sheet1")).getPath(), "Automated Sheet")
                .forEach(System.out::println);
    }

   // @Test
    public void checkExcelProvider(){
        readDataProviderFromExcel("/home/bohdan/opensource/G48Automation/src/test/resources/testData/excel_out.xls",
                "Sheet1").forEach(
                objectArray -> System.out.println(Arrays.asList(objectArray)));
    }


   // @Test
    public void checkDbQuery(){
        /*
        String login = executeQueryWithResult(
                "select * from data.users where id = 1",
                "username").get(0).toString();
        String password = executeQueryWithResult(
                "select * from data.users where id = 1",
                "password").get(0).toString();
       System.out.println("Login: "+ login+" Password: " + password);

         */
        executeQuery("delete from data.users where id = 5");
    }

    @Test
    public void checkSystemProperty(){
        System.setProperty("login", "BKuso");
        String username = System.getProperty("username", "");
    }

    //@Test
    public void someTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/chrome/84.0/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://localhost");
        try {
            driver.findElement(By.id("login")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("admin");
            driver.findElement(By.id("submit")).click();
            driver.findElements(By.id("list")).forEach(element -> Assert.assertTrue(element.getText().contains("photo")));
            driver.findElement(By.id("logout")).click();
        } catch (Throwable t){
           throw new AssertionError(t);
        } finally {
            driver.quit();
        }
    }

}
