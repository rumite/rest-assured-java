import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void openFacebook() {
        String baseUrl = ConfigLoader.getProperty("telegram.api.base_url");
        String token = ConfigLoader.getProperty("telegram.api.token");

        // New instance of RequestSpecification
        RequestSpecification request = RestAssured.given();

        // Define request specs
        Response response = request.baseUri(baseUrl)
                .and().basePath("/bot" + token + "/getMe")
                .get();

        System.out.println(response.asString());
    }

}
