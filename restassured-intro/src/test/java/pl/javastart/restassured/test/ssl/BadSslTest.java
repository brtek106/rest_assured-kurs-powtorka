package pl.javastart.restassured.test.ssl;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BadSslTest {

    @Test
    public void sslCertExpiredTest() {

        RequestSpecification requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation().build();
        given().relaxedHTTPSValidation().when().get("https://expired.badssl.com/").then().statusCode(200);
    }
}
