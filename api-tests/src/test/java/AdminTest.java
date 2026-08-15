import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;


@Tag("ui")
public class AdminTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @Test
    void driverTest() {
        Random random = new Random();
        int s = random.nextInt(1, 100);
        driver.findElement(By.xpath("//*[@class='btn-outline']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret123");
        driver.findElement(By.xpath("//*[@class='primary']")).click();
        driver.findElement(By.xpath("//*[@id='n-name']")).sendKeys("Товар"+s);
        driver.findElement(By.xpath("//*[@id='n-price']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id='add-btn']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Вернуться')]")).click();
        List<WebElement> foundElements = driver.findElements(By.xpath("//*[@class='product-card']"));
        Assertions.assertThat(foundElements)
                .as("В списке должен быть товар с названием - Товар"+s)
                .extracting(WebElement::getText)
                .anyMatch(text -> text.contains("Товар"+s));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
