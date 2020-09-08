package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@ToString
public class Post {

    @Setter
    @Getter
    @Column(name = "folder_id")
    private String folderId;

    public Post() {

    }
}
