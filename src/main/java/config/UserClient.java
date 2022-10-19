package config;
import io.restassured.response.ValidatableResponse;
import static config.Config.*;
import static io.restassured.RestAssured.given;

public class UserClient {
    public ValidatableResponse create(User user){
        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .body(user)
                .when()
                .post(REGISTER)
                .then().log().all()
                .assertThat();
    }

    public ValidatableResponse delete(User user, String accessToken){
        return given().log().all()
                .header("Authorization", accessToken)
                .baseUri(URL)
                .body(user)
                .when()
                .delete(USER)
                .then().log().all()
                .assertThat();
    }
}