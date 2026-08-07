import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rest.assertions.BasicApiAssert;
import rest.endpoints.Urls;

import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static rest.RestApiBuilder.getBuilder;

@Tag("Rest")
public class RestAssuredTest {
    public record Request1 (String foo, Integer foo2) {}
    public record Good (String name, Double price) {}

    private RequestSpecification basicRQ = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .setAuth(basic("admin","secret123"))
            .build();

    private RequestSpecification basicRQ1 = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .log(LogDetail.ALL)
            .addQueryParam("page",0)
            .addQueryParam("size",100)
            .build();


    @Test
    void listTest1() {
        given()
                .baseUri("http://localhost:8080")
                .log().all()
                .queryParam("page",0)
                .queryParam("size",1000)
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("goods", hasSize(0));
    }

    @Test
    void listTest2() {
        given()
                .spec(basicRQ1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("goods", hasSize(0));
    }

    @Test
    void listTest3() {
        given()
                .spec(basicRQ)
                .body("""
                        {"name": "char2", "price": 112.1}  \s
                                             \s""")
                .post("/goods/add")
                .then()
                .log().all()
                .statusCode(200);

        given()
                .spec(basicRQ1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("goods.name", hasItem("char2"));

    }


    @Test
    void listTest4() {

        Random random = new Random();
        int s = random.nextInt(1, 100);
        String d = "Table"+s;
        double t = random.nextDouble(1, 1000);
        Response response1 = given()
                .spec(basicRQ)
                .body(new Good(d, t))
                .post("/goods/add");
        BasicApiAssert.assertThat(response1)
                .statusCodeIsEquals(200)
                .fieldIsExists("data.id")
                .fieldIsExists("message")
                .fieldIsEqual("message","success");



        Response response = given()
                .spec(basicRQ1)
                .get("/goods/list");
                BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("goods.name")
                .fieldIsExists("goods.id")
                .fieldIsExists("goods.price")
                .listContainsElement("goods.name",d);




    }


}

