package tests.ui;

import helpers.FileHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static helpers.ExcelHelper.readDataFromExcelFile;
import static helpers.ExcelHelper.writeToExcelFileAndGet;
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

    @Test
    public void someExcel(){
        readDataFromExcelFile(
                writeToExcelFileAndGet(
                    "/home/bohdan/opensource/G48Automation/target/outputFiles/outputExcel.xls",
                            readDataFromExcelFile(
                            "/home/bohdan/opensource/G48Automation/src/test/resources/testData/excel_out.xls",
                        "Sheet1")).getPath(), "Automated Sheet")
                .forEach(System.out::println);
    }
}
