import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import java.time.Duration;
import java.util.Random;


public class SelenideTest1 {
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
        $x("//*[@id='add-btn']").click();
        sleep(2000);
        $x("//*[contains(text(), 'Вернуться')]").click();
        ElementsCollection cardTitleList = $$x("//*[contains(@id, card)]/h4");
        sleep(2000);
        cardTitleList.forEach(cardTitle -> {
            System.out.println(cardTitle.text());

        });
        cardTitleList.last().shouldHave(text("Товар"+s));
    }

    @Test
    void PurchaseGoodTest() {
        SelenideElement good = $x("//*[@data-action='add-to-cart'][@data-id='1']");
        good.should(visible, Duration.ofSeconds(10));
        good.click();
        sleep(2000);
        SelenideElement cartbox = $x("//*[@id='open-cart-btn']");
        cartbox.should(visible, Duration.ofSeconds(10));
        cartbox.click();
        sleep(2000);
        SelenideElement card = $x("//*[@class='cart-item']");
        card.getText();
        System.out.println(card.getText());
        card.should(attribute("id","cart-item-1"));
    }

    @Test
    void LoginTest() {
        Random random = new Random();
        int s = random.nextInt(1, 100);
        SelenideElement admin = $x("//*[@class='btn-outline']");
        admin.should(visible, Duration.ofSeconds(10));
        admin.click();
        sleep(2000);
        $x("//*[@id='username']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='username']").sendKeys("admin");
        $x("//*[@id='password']").sendKeys("secret"+s);
        $x("//*[@class='primary']").click();
        sleep(2000);
        SelenideElement error = $x("//*[@class='alert alert-danger']");
        error.getText();
        System.out.println(error.getText());
        error.should(text("Неверные учетные данные пользователя"));
    }

    @Test
    void ReloadTest() {
        SelenideElement add = $x("//*[@data-action='add-to-cart'][@data-id='1']");
        add.should(visible, Duration.ofSeconds(10));
        add.click();
        sleep(2000);
        $x("//*[@id='open-cart-btn']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='open-cart-btn']").click();
        sleep(2000);
        refresh();
        SelenideElement cash = $x("//*[@id='cart-count']");
        cash.getText();
        System.out.println(cash.getText());
        cash.should(text("1"));
    }

    @Test
    void AllertTest() {
        SelenideElement add = $x("//*[@data-action='add-to-cart']");
        add.should(visible, Duration.ofSeconds(10));
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();
        sleep(2000);
        $x("//*[@id='open-cart-btn']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='open-cart-btn']").click();
        sleep(2000);
        $x("//*[@id='makeOrder']").should(visible,Duration.ofSeconds(10));
        $x("//*[@id='makeOrder']").click();
        sleep(2000);
        Alert activeAlert = Selenide.switchTo().alert();
        System.out.println(activeAlert.getText());
        sleep(2000);
        activeAlert.accept();
        sleep(2000);

        }




}

