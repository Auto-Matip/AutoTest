package rest.assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BasicApiAssert extends AbstractAssert<BasicApiAssert, Response> {


   public BasicApiAssert(Response actual) {
       super(actual, BasicApiAssert.class);
       actual.prettyPrint();
   }
   public static BasicApiAssert assertThat(Response actual) {
       return new BasicApiAssert(actual);
   }

   public BasicApiAssert statusCodeIsEquals(int code){
       Assertions.assertThat(actual.statusCode())
               .as("Status code must be %d".formatted(code))
               .isEqualTo(code);
       return this;
   }

   public BasicApiAssert fieldIsExists(String path) {
       Assertions.assertThat(actual.jsonPath().getString(path))
               .as("Field with path %s must be exists!".formatted(path))
               .isNotNull();
       return this;
   }

    public BasicApiAssert fieldIsEqual(String path, String value) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Field with path %s must be equal to %s!".formatted(path,value))
                .isEqualToIgnoringCase(value);
        return this;
    }

   public BasicApiAssert headerIsEqual(String header, String value) {
       Assertions.assertThat(actual.getHeader(header))
               .as("Header '%s' must be equal '%s'".formatted(header, value))
               .isEqualToIgnoringCase(value);
       return this;
   }

   public BasicApiAssert listSizeIsEqualOrGreater(String path, int size) {
       Assertions.assertThat(actual.jsonPath().getList(path, String.class))
               .as("List with path %s must be size %d or greater".formatted(path, size))
               .hasSizeGreaterThanOrEqualTo(size);
       return this;
   }

    public BasicApiAssert listContainsElement(String path, String value) {
        Assertions.assertThat(actual.jsonPath().getList(path, String.class))
                .as("List with path %s must contains element %s".formatted(path, value))
                .contains(value);
        return this;
    }


}
