package com.thoughtworks.felix.training.picture.picturesod.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApproverDTO {

    @JsonProperty("group_id")
    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public ApproverDTO setGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }
}
