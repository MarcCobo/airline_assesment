
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
        chromeDriver.manage().window().maximize();
    }

//    @AfterAll
//    public static void tearDown(){
//        chromeDriver.quit();
//    }

    private void insertFlightData(String origin, String destination, String startDate, String endDate){
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
    private static void fillFormData(String name, String surname, String age, String nationality,
                                     String dni, String email, boolean bags) {
        WebElement nameField = chromeDriver.findElement(
                By.xpath("//input[@placeholder='Enter name']"));
        nameField.sendKeys(name);

        WebElement surnameField = chromeDriver.findElement(
                By.xpath("//input[@placeholder='Enter surname']"));
        surnameField.sendKeys(surname);

        WebElement ageField = chromeDriver.findElement(
                By.xpath("//input[@placeholder='Enter age']"));
        ageField.sendKeys(age);

        WebElement nationalityField = chromeDriver.findElement(
                By.xpath("//input[@placeholder='Enter nationality']"));
        nationalityField.sendKeys(nationality);

        WebElement dniField = chromeDriver.findElement(
                By.xpath("//input[contains(@placeholder,'Enter dni')]"));
        dniField.sendKeys(dni);

        WebElement emailField = chromeDriver.findElement(
                By.xpath("//input[contains(@placeholder,'Enter email')]"));
        emailField.sendKeys(email);

        if(bags){
            WebElement bagsField = chromeDriver.findElement(
                    By.xpath("//input[@type='checkbox']"));
            bagsField.click();
        }
    }
    private static void submitReservation() {
        WebElement bookButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), 'Confirm')]"));
        bookButton.click();
    }

    @Test
    public void SubmitFlightConditions_CorrectData_UserIsInAvailableFlights() {
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/AvailableFlights"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void SubmitFlightConditions_NoStartDate_UserRemainsInHomePage() {
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertFalse(chromeDriver.getCurrentUrl().endsWith("/AvailableFlights"));

    }

    @Test
    public void SubmitFlightConditions_NoEndDate_UserRemainsInHomePage() {
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertFalse(chromeDriver.getCurrentUrl().endsWith("/AvailableFlights"));
    }

    @Test
    public void MakeReservation_CorrectData_UserIsRedirectedToSuccessPage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "23", "Spanish", "12345678A", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();
        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/success"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_NoName_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("", "Erena", "23", "Spanish", "12345678A", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_NoSurname_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "", "23", "Spanish", "12345678A", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_NoAge_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "", "Spanish", "12345678A", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_NoNationality_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "23", "", "12345678A", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_NoDni_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "23", "Spanish", "", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_IncorrectDniFormat_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "23", "Spanish", "2424AAA", "test@gmail.com", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_NoEmail_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "23", "Spanish", "12345678A", "", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }

    @Test
    public void MakeReservation_IncorrectEmailFormat_UserIsRedirectedToFailurePage() {
        // Search for flights
        chromeDriver.get("http://localhost:3000/");
        insertFlightData("Sevilla", "Amsterdam", "19/11/2022", "22/11/2022");

        WebElement submitButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Find my Solights')]"));
        submitButton.click();

        WebElement startReservationButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        startReservationButton.click();

        fillFormData("David", "Erena", "23", "Spanish", "12345678A", "asdasdsad", false);

        WebElement addPassengerButton = chromeDriver.findElement(
                By.xpath("//button[contains(text(), '+')]"));
        addPassengerButton.click();

        submitReservation();

        boolean isUrlReached = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("http://localhost:3000/fail"));
        Assertions.assertTrue(isUrlReached);
    }
}
