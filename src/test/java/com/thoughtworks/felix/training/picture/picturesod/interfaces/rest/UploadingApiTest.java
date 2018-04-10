package com.thoughtworks.felix.training.picture.picturesod.interfaces.rest;

import com.thoughtworks.felix.training.picture.picturesod.support.ApiTest;
import org.junit.Test;

import static com.thoughtworks.felix.training.picture.picturesod.support.TestHelper.readFileFrom;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class UploadingApiTest extends ApiTest {

    private static final String UPLOADING_URL = "/uploading";
    private static final String GROUP_APPROVAL_URL = "uploading/1/approval";
    private static final String GENERAL_APPROVAL_URL = "/uploading/3/approval";


    @Test
    public void should_uploading_without_group_id_success() {
        given()
                .multiPart(readFileFrom("mongo.png"))
                .when()
                .post(UPLOADING_URL)
                .then()
                .statusCode(201)
                .header("Location", containsString("uploading/"));
    }

    @Test
    public void should_uploading_with_group_id_success() {
        given()
                .multiPart(readFileFrom("rails.png"))
                .when()
                .post(UPLOADING_URL)
                .then()
                .statusCode(201)
                .header("Location", containsString("uploading/"));
    }

    @Test
    public void should_uploading_general_approval_finished() {
        given()
                .when()
                .post(GENERAL_APPROVAL_URL)
                .then()
                .statusCode(201)
                .header("Location", "uploading/3/approval");
    }

    @Test
    public void should_uploading_group_approval_finished() {
        given()
                .when()
                .post(GROUP_APPROVAL_URL)
                .then()
                .statusCode(201)
                .header("Location", "uploading/1/approval");
    }
}