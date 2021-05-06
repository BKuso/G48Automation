package tests.ui;

import dbModels.Users;
import helpers.FileHelper;
import org.javalite.activejdbc.DB;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static helpers.DbHelper.executeQuery;
import static helpers.DbHelper.executeQueryWithResult;
import static helpers.ExcelHelper.*;
import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;
import static org.junit.Assert.assertTrue;

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

        readFile(writeFileAndGet(data, "our_test.txt")).forEach(System.out::println);
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

    @Test
    public void checkExcelProvider(){
        readDataProviderFromExcel("/home/bohdan/opensource/G48Automation/src/test/resources/testData/excel_out.xls",
                "Sheet1").forEach(
                objectArray -> System.out.println(Arrays.asList(objectArray)));
    }

    @Ignore("Потому что нет соедения с базой")
    @Test
    public void checkDbTest(){
        new DB("study")
                .open(
                        "org.postgresql.Driver",
                        "jdbc:postgresql://172.17.0.5:5432/study",
                        "postgres",
                        "postgres");
        //create
        new Users()
                .set("username", "test")
                .set("password", "test")
                .saveIt();
        //read
        System.out.println(
                Users.findFirst("username = ?", "admin"));
        //update
        Users.findFirst("username = ?", "admin")
                .set("password", String.valueOf(new Date().getTime()))
                .saveIt();

        //delete
        Users.findFirst("username = ?", "test").delete();

        //delete from users where id = 3
       // System.out.println(Users.findById(1));

        new DB("study").close();
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


}
