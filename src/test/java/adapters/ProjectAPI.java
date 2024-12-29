package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.qase.CreateProjectRq;
import models.qase.CreateProjectRs;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class ProjectAPI {
    public final String token = PropertyReader.getProperty("qase.token");
    public final String URL = PropertyReader.getProperty("qase.base.url");

    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public RequestSpecification spec =
            given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .header("Token", token);

    public CreateProjectRs createProject(CreateProjectRq createProjectRq) {
        return
                given()
                .spec(spec)
                .body(gson.toJson(createProjectRq))
                .when()
                .post(URL)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateProjectRs.class);
    }

    public void deleteProject(String projectCode) {
        given()
                .spec(spec)
                .when()
                .delete(URL + projectCode)
                .then()
                .log().all()
                .statusCode(200);
    }

    public void getProject(String projectCode) {
        given()
                .spec(spec)
                .when()
                .get(URL + projectCode)
                .then()
                .log().all()
                .statusCode(200);
    }
}
