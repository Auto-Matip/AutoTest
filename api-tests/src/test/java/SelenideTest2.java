import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import rest.endpoints.GoodsApi;

import java.time.Duration;
import java.util.Random;


public class SelenideTest2 {

    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    @Test
       void AddGoodTest() {
        SelenideElement admin = $x("//*[@class='btn-outline']");
        admin.should(visible, Duration.ofSeconds(10));
        admin.click();
        sleep(2000);
        $x("//*[@id='username']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='username']").sendKeys("admin");
        $x("//*[@id='password']").sendKeys("secret123");
        $x("//*[@class='primary']").click();
        sleep(2000);
        for (int i = 1; i <= 3; i++) {
            new GoodsApi().createGood("Товар №" + i, 10.0 + i);
        }
        refresh();
        sleep(2000);
        $x("//*[contains(text(), 'Вернуться')]").click();
        ElementsCollection cardTitleList = $$x("//*[contains(@id, card)]/h4");
        sleep(2000);
        cardTitleList.forEach(cardTitle -> {
            System.out.println(cardTitle.text());

        });
        cardTitleList.last().shouldHave(text("Товар №3"));
        for (int i = 1; i <= 3; i++) {
            $x("//*[@data-action='add-to-cart'][@data-id='" + i + "']").click();
        }
        sleep(2000);
        $x("//*[@id='open-cart-btn']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='open-cart-btn']").click();
        sleep(2000);
        $x("//*[@id='makeOrder']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='makeOrder']").click();
        $x("//*[@class='toast']").should(visible,Duration.ofSeconds(10));
        $x("//*[@class='toast']").shouldHave(text("Заказ принят в обработку!"));

    }

    @AfterEach
    void delete() {
        for (int i = 1; i <= 3; i++) {
            String id = "" + i;
            new GoodsApi().DeleteGoodId(id);
            id = null;

        }
    }


}
