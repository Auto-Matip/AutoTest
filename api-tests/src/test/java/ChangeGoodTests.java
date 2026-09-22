import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;

import java.util.Random;

@DisplayName("[PATCH]/goods/Id")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("ChangeGood")
public class ChangeGoodTests {

    Random random = new Random();
    int s = random.nextInt(1, 100);
    double price = random.nextDouble(1, 1000);
    String goodName = "Bed"+s;

    @Test
    @Order(10)
    @DisplayName("200")
    @Step("Успешное изменение товара")
    void changeGoodId() {
        Response response = new GoodsApi().ChangeGoodId("1",goodName,price);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("id")
                .fieldIsExists("name")
                .fieldIsExists("price");
    }

    @Test
    @Order(11)
    @DisplayName("Create Duplicate")
    @Step("Создание дубликата товара")
    void addNewGoodWithWrongName(){
        Response response = new GoodsApi().createGood("Char",2.0d);

    }

    @Test
    @Order(12)
    @DisplayName("400")
    @Step("Проверка невозможности создания двух товаров с одинаковым именем")
    void changeGoodId1() {
        Response response = new GoodsApi().ChangeGoodId("1","Char",price);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(400);

    }
    @Test
    @Order(13)
    @Step("Проверка что если попытаться изменить несуществующий товар то получаем код - 404")
    @DisplayName("404")
    void changeGoodId2() {
        Response response = new GoodsApi().ChangeGoodId("0",goodName, price);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(404);

    }

}
