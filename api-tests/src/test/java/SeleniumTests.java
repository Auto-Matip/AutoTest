import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Tag("ui")
public class SeleniumTests {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @Test
    void driverTest() {
        driver.findElement(By.xpath("//*[@data-action='qty-change'][@data-step='1'][@data-id='1']")).click();
        Assertions.assertThat(driver.findElement(By.id("q-1")).getAttribute("value"))
                .as("Поле ввода количества должно быть равно 2")
                .isEqualTo("2");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
