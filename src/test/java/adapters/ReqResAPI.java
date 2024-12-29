package adapters;

import models.qase.GetSingleUserRs;
import models.reqres.CreateSingleUserRq;
import models.reqres.CreateSingleUserRs;
import models.reqres.UpdateSingleUserRq;
import models.reqres.UpdateSingleUserRs;

import static io.restassured.RestAssured.given;

public class ReqResAPI extends BaseReqResAPI {
    public GetSingleUserRs getSingleUser() {
        return
                given()
                        .spec(spec)
                        .when()
                        .get(URL + "2")
                        .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .as(GetSingleUserRs.class);
    }

    public CreateSingleUserRs createSingleUser(CreateSingleUserRq createSingleUserRq) {
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(createSingleUserRq))
                        .when()
                        .post(URL)
                        .then()
                        .log().all()
                        .assertThat()
                        .statusCode(201)
                        .extract()
                        .as(CreateSingleUserRs.class);

    }

    public UpdateSingleUserRs updateSingleUser(UpdateSingleUserRq updateSingleUserRq) {
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(updateSingleUserRq))
                        .when()
                        .patch(URL + "2")
                        .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .as(UpdateSingleUserRs.class);
    }

    public void deleteSingleUser() {
        given()
                .when()
                .delete(URL + "2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
}
