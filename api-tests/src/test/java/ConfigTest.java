import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ConfigTest {


    @BeforeEach
    void setup() {
        Properties config = ConfigMain.loadProperties();
        String targetUrl = config.getProperty("URL");
        Selenide.open(targetUrl);
        System.out.println(config.getProperty("URL"));
        System.out.println(config.getProperty("TIMEOUT"));
        System.out.println(config.getProperty("LOGGLEVEL"));
        System.out.println(config.getProperty("GOOD_NAME"));
        System.out.println(config.getProperty("GOOD_PRICE"));
    }


    @Test
    void driverTest() {
        Properties config = ConfigMain.loadProperties();
        String login = config.getProperty("LOGIN");
        String password = config.getProperty("PASSWORD");
        String good_name = config.getProperty("GOOD_NAME");
        String good_price = config.getProperty("GOOD_PRICE");
        String timeout = config.getProperty("TIMEOUT");
        int value = Integer.parseInt(timeout);
        Random random = new Random();
        int s = random.nextInt(1, 100);
        sleep(value);
        SelenideElement admin = $x("//*[@class='btn-outline']");
        admin.should(visible, Duration.ofSeconds(10));
        admin.click();
        sleep(value);
        $x("//*[@id='username']").should(visible, Duration.ofSeconds(10));
        $x("//*[@id='username']").sendKeys(login);
        $x("//*[@id='password']").sendKeys(password);
        $x("//*[@class='primary']").click();
        sleep(value);
        $x("//*[@id='n-name']").should(visible, Duration.ofSeconds(10));
        $x("//*[@id='n-name']").sendKeys(good_name + s);
        $x("//*[@id='n-price']").sendKeys(good_price);
        sleep(value);
        $x("//*[@id='add-btn']").click();
        $x("//*[@id='toast-container']//div").should(visible, Duration.ofSeconds(10));
        $x("//*[@id='toast-container']//div").shouldHave(text("Товар успешно добавлен!"));
        sleep(value);
        $x("//*[contains(text(), 'Вернуться')]").should(visible,Duration.ofSeconds(10));
        $x("//*[contains(text(), 'Вернуться')]").click();
        sleep(value);

    }

    @AfterEach
    void tearDown() {
        Properties config = ConfigMain.loadProperties();
        String timeout = config.getProperty("TIMEOUT");
        int value = Integer.parseInt(timeout);
        $x("//*[@class='btn-outline']").click();
        $x("//*[@data-action='delete']").click();
        Alert activeAlert = Selenide.switchTo().alert();
        sleep(value);
        activeAlert.accept();

    }

}


