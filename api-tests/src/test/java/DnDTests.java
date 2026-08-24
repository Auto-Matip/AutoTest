import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import rest.endpoints.GoodsApi;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DnDTests {

    SelenideElement firstCard = $x("//*[@id='card-1']");
    SelenideElement cartButton = $x("//*[@id='open-cart-btn']");

    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    @Test
    void DnDTest() {

        sleep(2000);
        firstCard.dragAndDrop(DragAndDropOptions.to(cartButton));
        $x("//*[@class='toast']").should(Condition.visible,Duration.ofSeconds(10));
        $x("//*[@class='toast']").shouldHave(text("Товар №1 (1 шт.) добавлен в корзину"));
        sleep(2000);

    }

    @Test
    void DeleteTest() {

        sleep(2000);
        firstCard.dragAndDrop(DragAndDropOptions.to(cartButton));
        $x("//*[@class='toast']").should(Condition.visible,Duration.ofSeconds(10));
        $x("//*[@class='toast']").shouldHave(text("Товар №1 (1 шт.) добавлен в корзину"));
        sleep(2000);
        cartButton.click();
        sleep(1000);
        $x("//*[@class='cart-item']").should(visible,Duration.ofSeconds(10));
        $x("//*[@class='cart-item']").shouldHave(text("Товар №1"));
        $x("//*[@data-action='remove']").click();
        sleep(1000);
        $x("//*[@class='cart-item']").shouldNotBe(visible,Duration.ofSeconds(10));
        $x("//*[@id='empty-cart']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='empty-cart']").shouldHave(text("Пусто"));
        $x("//*[@id='total-price']").shouldHave(text("0"));

    }




}