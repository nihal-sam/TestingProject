package seleniumprojec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class InvalidLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        
        // Navigate to Login Page
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'profile.php#login')]")).click();
        Thread.sleep(2000);

        // Enter invalid credentials
        driver.findElement(By.id("txt-username")).sendKeys("nihal842");
        driver.findElement(By.id("txt-password")).sendKeys("89765242900");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(2000); // Wait for the error message

        // Check if the error message is displayed
        boolean isLoginFailed = driver.getPageSource().contains("Login failed!");
        if (isLoginFailed) {
            System.out.println("Login failed. Navigating back to the main page.");
            driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        } else {
            System.out.println("Unexpected login success.");
        }

        Thread.sleep(4000);
        driver.quit();
    }
}

