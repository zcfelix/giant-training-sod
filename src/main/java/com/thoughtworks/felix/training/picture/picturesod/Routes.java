package com.thoughtworks.felix.training.picture.picturesod;


import com.thoughtworks.felix.training.picture.picturesod.domain.Uploading;

import java.net.URI;

public abstract class Routes {
    private final String baseUri = "http://localhost/";

//    public static URI imageUri(Image image) {
//        return URI.create("images/" + image.getId());
//    }

    public static URI approvalURI(Uploading uploading) {
        return URI.create("uploading/" + uploading.getId() + "/approval");
    }

    public static URI uploadingURI(Uploading uploading) {
        return URI.create("uploading/" + uploading.getId());
    }
}
