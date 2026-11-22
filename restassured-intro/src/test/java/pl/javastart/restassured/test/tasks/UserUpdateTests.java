package pl.javastart.restassured.test.tasks;

import org.testng.annotations.Test;
import pl.javastart.main.pojo.user.User;

import static io.restassured.RestAssured.given;

public class UserUpdateTests extends TestBase {

    @Test
    public void givenCorrectUserDataWhenFirstNameLastNameAreUpdatedThenUserDataIsUpdatedTest() {

        User user = new User();
        user.setId(555);
        user.setUsername("jane");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setEmail("janedoe@gmail.com");
        user.setPassword("12345");
        user.setPhone("+12345678");
        user.setUserStatus(1);

        given()
                .contentType("application/json")
                .body(user)
                .when().post("user")
                .then().statusCode(200);

        user.setFirstName("Maria");
        user.setLastName("Kowalska");

        given()
                .contentType("application/json")
                .body(user)
                .pathParam("username", user.getUsername())
                .when().put("user/{username}")
                .then().statusCode(200);

        given()
                .contentType("application/json")
                .pathParam("username", user.getUsername())
                .when().get("user/{username}")
                .then().statusCode(200);
    }
}
