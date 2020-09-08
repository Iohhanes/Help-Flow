package com.helpflow.core.utils;

import lombok.Getter;

public enum GoogleDriveFilesType {

    FOLDER("application/vnd.google-apps.folder");

    @Getter
    private String mimeType;

    GoogleDriveFilesType(String mimeType) {
        this.mimeType = mimeType;
    }
}
