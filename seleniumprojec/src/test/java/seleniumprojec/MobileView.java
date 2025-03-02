package seleniumprojec;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;

public class MobileView {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriverManager.chromedriver().setup();
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 12 Pro");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        try { Thread.sleep(8000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();
    }
}


