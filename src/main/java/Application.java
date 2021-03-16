import models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static models.Car.count;
import static models.Type.NORMAL;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Тест");


    public static void main(String[] args) {
        LOG.info("=========Start========");
        System.setProperty("webdriver.chrome.driver", "/home/bohdan/opensource/G48Automation/src/main/resources/drivers/chrome/84.0/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try {

            driver.get("https://github.com/login");
            driver.findElement(By.name("login")).sendKeys("BKuso");
            driver.findElement(By.name("password")).sendKeys("123455as");
            driver.findElement(By.name("commit")).click();

            LOG.error(driver.findElement(By.xpath("//div[@class = 'flash flash-full flash-error ']/div")).getText());
        } finally {
            driver.quit();
        }

        /*
        String[] colors = new String[]{
                "red",
                "blue",
                "green",
                "yellow"};

        List<Car> cars = new ArrayList<>();

        for (String color : colors){
            LOG.debug(format("Передаём цвет %s в конструктор Car", color));
            switch (color){
                case "red":
                    cars.add(new Car("Ferrari", color));
                    break;
                case "blue":
                    cars.add(new Car("Nissan", color));
                    break;
                case "yellow":
                    cars.add(new Car("Grandmother car", color));
                    break;
                default:
                    cars.add(new Car("Polo", color));
                    break;
            }
            new Car(NORMAL);



        }
        LOG.info("Текущее количество машин: " + count);
        try{
            throw new IllegalArgumentException(
                    "Неправильно введено значение какой то " +
                            "переменной");
        } catch (IllegalArgumentException i){
            LOG.error(i);
        }
        LOG.info(cars);

         */


        LOG.info("=========Finish========");
    }

}