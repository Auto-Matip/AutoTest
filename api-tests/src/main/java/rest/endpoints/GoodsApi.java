package rest.endpoints;

import io.restassured.response.Response;

import static rest.RestApiBuilder.getBuilder;
import static rest.endpoints.Urls.ADD;
import static rest.endpoints.Urls.LIST;

public class GoodsApi {
    public record DTOGood(String name, double price){}

    public Response createGood(String name, double price){
        return getBuilder().setContentJSON().getSpec()
                .body(new DTOGood(name, price))
                .post(ADD);
    }

    public Response getGood(){
        return getBuilder().setContentJSON().getSpec()
                .get(LIST);
    }

    public Response getGoodId(String id){
        return getBuilder().setContentJSON().getSpec()
                .get("/"+id);
    }
    public Response DeleteGoodId(String id){
        return getBuilder().setContentJSON().getSpec()
                .delete("/"+id);
    }
    public Response ChangeGoodId(String id, String name, double price){
        return getBuilder().setContentJSON().getSpec()
                .body(new DTOGood(name, price))
                .patch("/"+id);
    }


}
