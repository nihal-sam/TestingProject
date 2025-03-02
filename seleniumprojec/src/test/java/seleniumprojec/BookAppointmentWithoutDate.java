package seleniumprojec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BookAppointmentWithoutDate {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 1: Open the website
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        
        // Step 2: Open the menu and navigate to login
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'profile.php#login')]")).click();
        Thread.sleep(2000);

        // Step 3: Enter valid login credentials
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(2000);

        // Step 4: Navigate to "Make Appointment" page
        driver.findElement(By.id("combo_facility")).click(); // Selecting Facility
        driver.findElement(By.xpath("//option[@value='Hongkong CURA Healthcare Center']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("chk_hospotal_readmission")).click(); // Click 'Apply for hospital readmission'
        driver.findElement(By.id("radio_program_medicaid")).click(); // Select "Medicaid" program
        Thread.sleep(1000);

        // Step 5: Leave "Visit Date" field empty and enter a comment
        driver.findElement(By.id("txt_comment")).sendKeys("Automated test comment for negative scenario.");
        
        // Step 6: Click "Book Appointment" and check for the error
        driver.findElement(By.id("btn-book-appointment")).click();
        Thread.sleep(2000);

        // Step 7: Verify error and return to the main page
        WebElement errorMessage = driver.findElement(By.cssSelector("input#txt_visit_date:invalid"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Test Passed: Cannot book an appointment without a visit date.");
        } else {
            System.out.println("Test Failed: Appointment was booked without a visit date (possible bug).");
        }

        // Step 8: Navigate back to the main page
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        Thread.sleep(2000);

        // Step 9: Go to "History" page
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'History')]")).click();
        Thread.sleep(2000);

        // Step 10: Wait for 5 seconds and close the browser
        Thread.sleep(5000);
        driver.quit();
    }
}

