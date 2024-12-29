package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseReqResAPI {
    public final String URL = PropertyReader.getProperty("reqres.base.url");

    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public RequestSpecification spec =
            given()
                    .log().all()
                    .contentType(ContentType.JSON);
}
