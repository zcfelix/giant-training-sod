package com.thoughtworks.felix.training.picture.picturesod.domain;

import com.thoughtworks.felix.training.picture.picturesod.support.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ImageServiceTest {

    private ImageService service;

    @Before
    public void setUp() {
        service = new ImageService();
    }

    @Test
    public void should_save_image_success() {
        final File file = TestHelper.readFileFrom("mongo.png");
        service.saveImage(file.getAbsolutePath());
    }
}