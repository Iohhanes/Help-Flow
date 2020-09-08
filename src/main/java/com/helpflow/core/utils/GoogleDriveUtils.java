package com.helpflow.core.utils;

public class GoogleDriveUtils {

    private GoogleDriveUtils() {

    }

    public static String buildSubQFolder(String name) {
        return " name='" + name + "'";
    }

    public static String buildSubQFolder(String name, String parentId) {
        return " name='" + name + "' '" + parentId + "' in parents";
    }
}
