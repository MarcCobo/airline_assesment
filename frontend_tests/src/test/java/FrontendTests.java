
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrontendTests {

    private static ChromeDriver chromeDriver;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
    }

    private void insertFlightData(String origin, String destination, String startDate, String endDate){
        Select originSelect = new Select(new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("origin"))));
        originSelect.selectByValue(origin);
        Select destinationSelect = new Select(new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("destination"))));
        destinationSelect.selectByValue(destination);

        WebElement startDatePicker = chromeDriver.findElement(By.xpath("//form//input[@name='startDate']"));
        startDatePicker.sendKeys(startDate);

        WebElement endDatePicker = chromeDriver.findElement(By.xpath("//form//input[@name='endDate']"));
        endDatePicker.sendKeys(endDate);
    }

    @Test
    public void SubmitFlightConditions_CorrectData_UserIsInAvailableFlights() {
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Paris", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/AvailableFlights"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void SubmitFlightConditions_NoStartDate_UserRemainsInHomePage() {
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Paris", "", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertFalse(chromeDriver.getCurrentUrl().endsWith("/AvailableFlights"));

    }

    @Test
    public void SubmitFlightConditions_NoEndDate_UserRemainsInHomePage() {
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Paris", "19/11/2022", "");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertFalse(chromeDriver.getCurrentUrl().endsWith("/AvailableFlights"));

    }

    @Test
    public void MakeReservation_CorrectData_UserIsRedirectedToSuccessPage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Paris", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        // TODO: Click on one flight
        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        startReservationButton.click();

        // TODO: Fill form data
        WebElement nameField = chromeDriver.findElement(
                By.xpath("//button[contains(text(),'Find my Solights')]"));
        nameField.sendKeys("David");

        WebElement surnameField = chromeDriver.findElement(
                By.xpath("//button[contains(text(),'Find my Solights')]"));
        surnameField.sendKeys("Erena");

        WebElement ageField = chromeDriver.findElement(
                By.xpath("//button[contains(text(),'Find my Solights')]"));
        ageField.sendKeys("23");

        WebElement nationalityField = chromeDriver.findElement(
                By.xpath("//button[contains(text(),'Find my Solights')]"));
        nationalityField.sendKeys("Spanish");

        WebElement dniField = chromeDriver.findElement(
                By.xpath("//button[contains(text(),'Find my Solights')]"));
        dniField.sendKeys("12345678A");

        WebElement bagsField = chromeDriver.findElement(
                By.xpath("//button[contains(text(),'Find my Solights')]"));
        bagsField.click();

        WebElement makeReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        makeReservationButton.click();
    }
}
