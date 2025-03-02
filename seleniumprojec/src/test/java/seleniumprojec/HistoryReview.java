package seleniumprojec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class HistoryReview {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(@href,'profile.php#login')]")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@href='history.php#history']")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("menu-close")).click();

        System.out.println(driver.getCurrentUrl().contains("history.php#history") 
            ? "Successfully navigated to History page." 
            : "Failed to navigate to History page.");
        
        driver.quit();
    }
}


