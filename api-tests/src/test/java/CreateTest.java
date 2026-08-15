import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;
import rest.endpoints.ParallelContext;

import java.util.Random;


@DisplayName("[POST]/goods/add")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("CR")

public class CreateTest {

    public static String sharedId;

    Random random = new Random();
    int s = random.nextInt(1, 100);
    int l = random.nextInt(1, 100);
    double price = random.nextDouble(1, 1000);
    String goodName = "Sofa"+s+l;


    @Test
    @Order(1)
    @DisplayName("200")
    void addNewGood() {
        Response response = new GoodsApi().createGood(goodName,price);
        String idAsString;
        idAsString = response.jsonPath().getString("data.id");
        sharedId = idAsString;
        TestData.itemId = sharedId;
        System.out.println(sharedId);
        System.out.println(TestData.itemId);
        //System.out.println(idAsString);
        //ParallelContext.set(sharedId);
        //System.out.println(ParallelContext.get());
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("data.id")
                .fieldIsExists("message")
                .fieldIsEqual("message","success");

    }
}
