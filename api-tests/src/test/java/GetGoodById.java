import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;


@DisplayName("[GET]/goods/Id")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("GetGoodById")
public class GetGoodById {

    @Test
    @Order(7)
    @DisplayName("200")
    void getGoodId() {
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
    void getGoodWithWrongId1() {
        Response response = new GoodsApi().getGoodId("0");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(404);

    }

    @Test
    @Order(9)
    @DisplayName("500")
    void getGoodWithWrongId() {
        Response response = new GoodsApi().getGoodId("99999999");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(500);

    }
}
