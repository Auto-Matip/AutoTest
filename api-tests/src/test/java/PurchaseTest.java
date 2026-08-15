import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Tag("ui")
public class PurchaseTest {

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
        Assertions.assertThat(driver.findElement(By.xpath("//*[@class='cart-item']")).getAttribute("id"))
                .as("В корзине должен быть товар с id=1")
                .isEqualToIgnoringCase("cart-item-1");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
