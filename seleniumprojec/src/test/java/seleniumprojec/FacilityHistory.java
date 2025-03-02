package seleniumprojec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class FacilityHistory {
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

        driver.findElement(By.id("combo_facility")).sendKeys("Seoul CURA Healthcare Center");
        driver.findElement(By.id("radio_program_medicare")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("06/10/2025");
        driver.findElement(By.id("txt_comment")).sendKeys("We have visit at 9 AM");
        driver.findElement(By.id("btn-book-appointment")).click();
        Thread.sleep(4000);

        driver.findElement(By.linkText("Go to Homepage")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("combo_facility")).sendKeys("Tokyo CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("09/05/2025");
        driver.findElement(By.id("txt_comment")).sendKeys("Proper respect for nurses");
        driver.findElement(By.id("btn-book-appointment")).click();
        Thread.sleep(4000);

        driver.findElement(By.linkText("Go to Homepage")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'history.php#history')]")).click();
        Thread.sleep(10000);

        driver.quit();
    }
}


