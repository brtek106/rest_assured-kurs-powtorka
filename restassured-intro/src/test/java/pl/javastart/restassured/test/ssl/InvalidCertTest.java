package pl.javastart.restassured.test.ssl;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InvalidCertTest {

    @Test
    public void untrustedRootTest() {
        given().relaxedHTTPSValidation().when().get("https://untrusted-root.badssl.com/").then().statusCode(200);
    }
}
