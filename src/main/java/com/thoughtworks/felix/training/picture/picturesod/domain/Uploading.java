package com.thoughtworks.felix.training.picture.picturesod.domain;

import javax.persistence.*;

@Entity
@Table(name = "uploading")
public class Uploading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "approval_count")
    private int approvalCount;


    private final static ImageService imageService = new ImageService();

    private Uploading() {
    }

    public Uploading(String path) {
        this.path = path;
        this.approvalCount = 0;
    }

    public Uploading(String path, Long groupId) {
        this.path = path;
        this.groupId = groupId;
        this.approvalCount = 0;
    }

    public void addApproval() {
        if (!isApprovalFinished()) {
            approvalCount += 1;
            if (isApprovalFinished()) {
                imageService.saveImage(path);
            }
        }
    }

    public boolean isApprovalFinished() {
        if (groupId == null) {
            return approvalCount == 1;
        } else {
            return approvalCount == 2;
        }
    }

    public Long getId() {
        return id;
    }
}
