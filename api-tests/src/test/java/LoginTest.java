import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;


@Tag("ui")
public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @RepeatedTest(5)
    void driverTest() {
        Random random = new Random();
        int s = random.nextInt(1, 100);
        driver.findElement(By.xpath("//*[@class='btn-outline']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret"+s);
        driver.findElement(By.xpath("//*[@class='primary']")).click();
        Assertions.assertThat(driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText())
                .as("Должно быть сообщение, что эти учетные данные - неверные")
                .isEqualToIgnoringCase("Неверные учетные данные пользователя");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}