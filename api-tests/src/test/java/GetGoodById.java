import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;
import rest.endpoints.ParallelContext;


@DisplayName("[GET]/goods/Id")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("GetGoodById")
public class GetGoodById {

    @Test
    @Order(7)
    @DisplayName("200")
    @Step("Успешный получение товара с id")
    void getGoodId() {
        System.out.println(ParallelContext.get());
        String id = ParallelContext.get();
        System.out.println(id);
        Response response = new GoodsApi().getGoodId("1");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("id")
                .fieldIsExists("name")
              .fieldIsExists("price");

    }

    @Test
    @Order(8)
    @DisplayName("404")
    @Step("Проверка что запрос товара с id = 0 возвращает 404 код")
    void getGoodWithWrongId1() {
        Response response = new GoodsApi().getGoodId("0");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(404);

    }

    @Test
    @Order(9)
    @DisplayName("500")
    @Step("Проверка что запрос товара с некорректным id возвращает 500 код")
    void getGoodWithWrongId() {
        Response response = new GoodsApi().getGoodId("99999999");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(500);

    }
}
