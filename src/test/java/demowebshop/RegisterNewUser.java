package demowebshop;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class RegisterNewUser {

    String firstName = "John",
            lastName = "Doe",
            email = "SDKA@CD.CD",
            password = "password";

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com/";
    }
    @Test
    void registerNewUser() {
            given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("FirstName", firstName)
                .formParam("LastName", lastName)
                .formParam("Email", email)
                .formParam("Password", password)
                .formParam("ConfirmPassword", password)
                .formParam("register-button", "Register")
                .when()
                .post()
                .then()
                .statusCode(200)
                .log().all();
    }

}
