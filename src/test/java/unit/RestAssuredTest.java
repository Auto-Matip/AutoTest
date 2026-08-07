package unit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {
    public record Request1 (String foo, Integer foo2) {}
    public record Good (String name, Double price) {}

    private RequestSpecification basicRQ = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            //.addQueryParam("page",0)
            //.addQueryParam("size",1)
            .setAuth(basic("admin","secret123"))
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
                .spec(basicRQ)
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
                        {"name": "char7", "price": 112.1}  \s
                                             \s""")
                .post("/goods/add")
                .then()
                .log().all()
                .statusCode(200);

        given()
                .spec(basicRQ)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("goods.name", hasItem("char7"));

    }


    @Test
    void listTest4() {
       Response response = given()
                .spec(basicRQ)
                .body("""
                        {"name": "table1", "price": 112.1}  \s
                                             \s""")
                .post("/goods/add");

        //Assertions.assertThat(response.jsonPath().getInt("id"));

        given()
                .spec(basicRQ)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("goods.name", hasItem("char7"));

    }

    @Test
    void listTest5() {
        given()
                .baseUri("http://localhost:8080")
                .log().all()
                .contentType(ContentType.JSON)
                //.body("""
                //        {"name": "table", "price": 112.1}  \s
                //                             \s""")
                .body(new Good("bar", 123.11))
                .auth()
                .basic("admin","secret123")
                .when()
                .post("/goods/add")
                .then()
                .log().all()
                .statusCode(200);
    }




    @Test
    void raTest() {
        given()
                .baseUri("http://localhost:8080")
                .log().all()
                .queryParam("page",0)
                .queryParam("size",1000)
                //.contentType(ContentType.JSON)
                //.body("""           {"foo": "bar", "foo2": `112}                         """)
                //.body(new Request1("bar", 123))
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200);
    }


    @Test
    void raTest1() {
        given()
                .spec(basicRQ)
                .queryParam("size",1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200);
    }


}
