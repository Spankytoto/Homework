package helper;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    @Step("Check availability of the website")
    public static boolean getWebSiteAvailability (String host) {
      Response response =  given()
                           .when()
                           .get(host)
                           .then()
                           .extract().response();

      return response.statusCode() == 200;
    }
}
