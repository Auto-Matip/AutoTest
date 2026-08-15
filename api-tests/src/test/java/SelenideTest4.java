import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import rest.endpoints.GoodsApi;

import java.time.Duration;
import java.util.Random;


public class SelenideTest4 {

    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    @Test
    void AddGoodTest() {
        Random random = new Random();
        int s = random.nextInt(1, 100);
        int t = random.nextInt(1, 100);
        SelenideElement admin = $x("//*[@class='btn-outline']");
        admin.should(visible, Duration.ofSeconds(10));
        admin.click();
        sleep(2000);
        $x("//*[@id='username']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='username']").sendKeys("admin");
        $x("//*[@id='password']").sendKeys("secret123");
        $x("//*[@class='primary']").click();
        sleep(2000);
        $x("//*[@id='n-name']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='n-name']").sendKeys("Товар"+s);
        $x("//*[@id='n-price']").sendKeys(""+t);
        sleep(2000);
        $x("//*[@id='add-btn']").click();
        $x("//*[@id='toast-container']//div").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='toast-container']//div").shouldHave(text("Товар успешно добавлен!"));

    }

    @Test
    void ChangeGoodTest() {
        Random random = new Random();
        int s = random.nextInt(1, 100);
        int t = random.nextInt(1, 100);
        SelenideElement admin = $x("//*[@class='btn-outline']");
        admin.should(visible, Duration.ofSeconds(10));
        admin.click();
        sleep(2000);
        $x("//*[@id='username']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='username']").sendKeys("admin");
        $x("//*[@id='password']").sendKeys("secret123");
        $x("//*[@class='primary']").click();
        sleep(2000);
        $x("//*[@id='n-name']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='n-name']").sendKeys("Товар"+s);
        $x("//*[@id='n-price']").sendKeys(""+t);
        sleep(2000);
        $x("//*[@id='add-btn']").click();
        $x("//*[@id='toast-container']//div").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='toast-container']//div").shouldHave(text("Товар успешно добавлен!"));
        sleep(2000);
        $x("//*[@id='tbody']//input[starts-with(@id, 'nm')]").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='tbody']//input[starts-with(@id, 'nm')]").clear();
        $x("//*[@id='tbody']//input[starts-with(@id, 'nm')]").sendKeys("Ковер");
        $x("//*[@id='tbody']//input[starts-with(@id, 'pr')]").clear();
        $x("//*[@id='tbody']//input[starts-with(@id, 'pr')]").sendKeys(""+s);
        $x("//*[@data-action='update']").click();
        $x("//*[@id='toast-container']//div").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='toast-container']//div").shouldHave(text("Товар #1 обновлен"));
        sleep(2000);
        $x("//*[contains(text(), 'Вернуться')]").should(visible,Duration.ofSeconds(10));
        $x("//*[contains(text(), 'Вернуться')]").click();
        ElementsCollection cardTitleList = $$x("//*[contains(@id, card)]/h4");
        sleep(2000);
        cardTitleList.forEach(cardTitle -> {
            System.out.println(cardTitle.text());

        });
        cardTitleList.last().shouldHave(text("Ковер"));
        $x("//*[@class='product-card']/div").shouldHave(text(""+s+" ₽"));

    }



    @AfterEach
    void delete() {
        $x("//*[@class='btn-outline']").click();
        $x("//*[@data-action='delete']").click();
        Alert activeAlert = Selenide.switchTo().alert();
        System.out.println(activeAlert.getText());
        sleep(2000);
        activeAlert.accept();
    }


}