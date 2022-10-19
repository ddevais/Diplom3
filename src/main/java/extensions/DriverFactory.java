package extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    static String browserName;

    public static WebDriver getBrowser() {
        browserName = System.getProperty("browser", "chrome");
        ChromeOptions options = new ChromeOptions();


        switch (browserName) {
            case "chrome": {

                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
                return new ChromeDriver();
            }
            case "yandex":{

                options.setBinary("C:\\Users\\Maxim\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxim\\Desktop\\chromedriver.exe");

                return new ChromeDriver(options);
            }
            default: {
                throw new RuntimeException("Такого браузера нет");
            }
        }

    }
}