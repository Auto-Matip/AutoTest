import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Tag("ui")
public class ReloadTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @RepeatedTest(5)
    void driverTest() {
        driver.findElement(By.xpath("//*[@data-action='add-to-cart'][@data-id='1']")).click();
        driver.findElement(By.xpath("//*[@id='open-cart-btn']")).click();
        driver.navigate().refresh();
        Assertions.assertThat(driver.findElement(By.xpath("//*[@id='cart-count']")).getText())
                .as("Корзина не должна быть пустая")
                .isNotEqualToIgnoringCase("0");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}