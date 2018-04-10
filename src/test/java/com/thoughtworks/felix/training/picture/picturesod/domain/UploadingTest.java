package com.thoughtworks.felix.training.picture.picturesod.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UploadingTest {

    private Uploading publicUploading;
    private Uploading groupUploading;



    @Before
    public void setUp() {
        final String path = "/tmp/uploading/test.png";
        publicUploading = new Uploading(path);
        groupUploading = new Uploading(path, 1L);
    }

//    @Test
//    public void should_public_uploading_need_one_approval() {
//        assertThat(publicUploading.isApprovalFinished(), is(false));
//        publicUploading.addApproval();
//        assertThat(publicUploading.isApprovalFinished(), is(true));
//    }
//
//    @Test
//    public void should_group_uploading_need_two_approval() {
//        assertThat(groupUploading.isApprovalFinished(), is(false));
//        groupUploading.addApproval();
//        assertThat(groupUploading.isApprovalFinished(), is(false));
//        groupUploading.addApproval();
//        assertThat(groupUploading.isApprovalFinished(), is(true));
//    }
//
//    @Test
//    public void should_uploading_be_saved_when_approval_finished() {
//        publicUploading.addApproval();
//        assertThat(publicUploading.isApprovalFinished(), is(true));
//    }
}