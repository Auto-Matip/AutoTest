import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;


@DisplayName("[DELETE]/goods/Id")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("DeleteGood")
public class DeleteGood {

    @Test
    @Order(14)
    @DisplayName("200")
    void deleteGoodId() {
        Response response = new GoodsApi().DeleteGoodId("1");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200);
    }
    @Test
    @Order(15)
    @DisplayName("200")
    void deleteGoodId2() {
        Response response = new GoodsApi().DeleteGoodId("2");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200);
    }

    @Test
    @Order(16)
    @DisplayName("404")
    void deleteGoodWithWrongId() {
        Response response = new GoodsApi().DeleteGoodId("0");
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(404);

    }

}
