import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import rest.endpoints.GoodsApi;

import java.time.Duration;
import java.util.Random;


public class SelenideTest3 {

    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    @Test
    void AddGoodTest() {
        Random random = new Random();
        int s = random.nextInt(1, 10);
        int t = random.nextInt(1, 10);
        int b = random.nextInt(1, 10);
        int sum = s + t + b;
        System.out.println(sum);
        sleep(2000);
        new GoodsApi().createGood("Товар №" + 1, s);
        new GoodsApi().createGood("Товар №" + 2, t);
        new GoodsApi().createGood("Товар №" + 3, b);
        refresh();
        sleep(2000);
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
        $x("//*[@id='total-price']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='total-price']").shouldHave(text(""+sum));

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