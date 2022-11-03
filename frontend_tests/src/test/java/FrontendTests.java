
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrontendTests {

    @Test
    public void FirstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("http://localhost:3000/");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Select originSelect = new Select(new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("origin"))));
        originSelect.selectByValue("Bigaa");
        Select destinationSelect = new Select(new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("destination"))));
        destinationSelect.selectByValue("Dongtou");

    }
}
