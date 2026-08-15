import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodsApi;
import rest.endpoints.ParallelContext;
import rest.endpoints.Urls;

import java.util.Random;

import static rest.RestApiBuilder.getBuilder;

@DisplayName("[POST]/goods/add")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("Create")
public class CreateGoodTests {
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
        System.out.println(idAsString);
        ParallelContext.set(sharedId);
        System.out.println(ParallelContext.get());
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("data.id")
                .fieldIsExists("message")
                .fieldIsEqual("message","success");

    }


    @Test
    @Order(2)
    @DisplayName("CheckId")
    void getGoods() {
        System.out.println(sharedId);
        Response response = new GoodsApi().getGood();
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("goods.id")
                .fieldIsExists("goods.name")
                .fieldIsExists("goods.price")
                .listContainsElement("goods.id",sharedId);

    }

    @Test
    @Order(3)
    @DisplayName("getGoodById")
    void getGoodId() {
        Response response = new GoodsApi().getGoodId(sharedId);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("id")
                .fieldIsExists("name")
                .fieldIsExists("price");

    }


    @Test
    @Order(4)
    @DisplayName("400")
    void addNewGoodWithNegativePrice(){
        Response response = new GoodsApi().createGood(goodName,-2.0d);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(400);
    }

    @Test
    @Order(5)
    @DisplayName("500")
    void addNewGoodWithWrongName(){
        Response response = new GoodsApi().createGood("Table # 4673",2.0d);
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(500);
    }


}
