package helper;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static boolean getWebSiteAvailability (String host) {
      Response response =  given()
                           .when()
                           .get(host)
                           .then()
                           .extract().response();

      return response.statusCode() == 200;
    }
}
