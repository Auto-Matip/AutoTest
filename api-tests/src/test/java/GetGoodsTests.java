import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;
import java.util.Random;

@DisplayName("[GET]/goods/list")

@Tag("GetGoods")
public class GetGoodsTests {

    @Test
    @Order(6)
    @DisplayName("200")
    @Step("Успешное получение списка товаров")
    void getGoods() {
        Response response = new GoodsApi().getGood();
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("goods.id")
                .fieldIsExists("goods.name")
                .fieldIsExists("goods.price");

    }


}
