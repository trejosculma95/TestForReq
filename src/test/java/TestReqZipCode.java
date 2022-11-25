import static io.restassured.RestAssured.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestReqZipCode {

    @BeforeAll
    public static void setUp() {
        baseURI= "https://api.zippopotam.us";
        basePath= "/us";
    }

    @Test
    public void verifyPlaceName() {

        String place = "San Francisco";
        given()
                .when()
                .log().all()
                .get("94105")
                .then()
                .log().all()
                //200=SC_OK code status response
                .statusCode(HttpStatus.SC_OK)
                .body("places[0]['place name']", equalTo(place))
                .extract().jsonPath().getString("places[0]['place name']");

    }
}
