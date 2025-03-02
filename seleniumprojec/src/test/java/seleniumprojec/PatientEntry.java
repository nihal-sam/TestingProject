package seleniumprojec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class PatientEntry {
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

        driver.findElement(By.id("combo_facility")).sendKeys("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("09/10/2025");
        driver.findElement(By.id("txt_comment")).sendKeys("Pancreatic disease treatment");
        driver.findElement(By.id("btn-book-appointment")).click();

        Thread.sleep(60000);
        driver.quit();
    }
}

