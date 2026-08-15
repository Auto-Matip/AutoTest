import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;
import rest.endpoints.ParallelContext;


@DisplayName("[DELETE]/goods/Id")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("Del")
public class DeleteTest {

    @Test
    @Order(2)
    @DisplayName("200")
    void deleteGoodId() {
        System.out.println(ParallelContext.get());
        String id = TestData.itemId;
        System.out.println(id);
        Response response = new GoodsApi().DeleteGoodId(id);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200);
    }


}
