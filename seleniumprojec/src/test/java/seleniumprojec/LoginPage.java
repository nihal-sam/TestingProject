package seleniumprojec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LoginPage {
    public static void main(String[] args) throws InterruptedException {
        // Setup Edge WebDriver automatically
        WebDriverManager.edgedriver().setup();

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait to handle loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the Katalon CURA website
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Click the "Make Appointment" button
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();

        // Enter username ("John Doe")
        WebElement usernameField = driver.findElement(By.id("txt-username"));
        usernameField.sendKeys("John Doe");

        // Enter password ("ThisIsNotAPassword")
        WebElement passwordField = driver.findElement(By.id("txt-password"));
        passwordField.sendKeys("ThisIsNotAPassword");

        // Click the login button
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        // Wait for 8 seconds after login
        Thread.sleep(8000); 

        // Close the browser
        driver.quit();
    }
}
