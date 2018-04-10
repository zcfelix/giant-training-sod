package com.thoughtworks.felix.training.picture.picturesod.interfaces.rest;

import com.thoughtworks.felix.training.picture.picturesod.domain.Uploading;
import com.thoughtworks.felix.training.picture.picturesod.domain.UploadingPathRepository;
import com.thoughtworks.felix.training.picture.picturesod.support.ApiUnitTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.anyLong;

public class UploadingApiUnitTest extends ApiUnitTest {

    private static final String APPROVAL_URL = "/uploading/1/approval";

    @Mock
    private UploadingPathRepository uploadingPathRepository;

    @InjectMocks
    private UploadingApi api;

    @Before
    public void setUp() {
        setUpApi(api);
    }

    @Test
    public void should_general_approval_without_group_id_success() {
        final Uploading uploading = new Uploading("/tmp/uploading/1");
        Mockito.when(uploadingPathRepository.findById(anyLong())).thenReturn(Optional.ofNullable(uploading));
        given()
                .when()
                .post(APPROVAL_URL)
                .then()
                .statusCode(201);
    }
}
