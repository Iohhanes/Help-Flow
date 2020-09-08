package com.helpflow.core.controller;

import com.google.api.services.drive.model.File;
import com.helpflow.core.model.entity.Post;
import com.helpflow.core.service.GoogleDriveService;
import com.helpflow.core.utils.GoogleDriveModel;
import com.helpflow.core.utils.GoogleDriveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drive")
public class TestController {

    private GoogleDriveService googleDriveService;

    @Autowired
    public TestController(GoogleDriveService googleDriveService) {
        this.googleDriveService = googleDriveService;
    }

    @GetMapping("/root")
    public String getRootFolder() {
        File rootFolder = googleDriveService.getFolder(GoogleDriveUtils.buildSubQFolder(GoogleDriveModel.ROOT_FOLDER_NAME));
        return rootFolder == null ? "" : rootFolder.getName() + "//" + rootFolder.getId();

    }

    @PostMapping("/createFolder")
    public void createPostFolder() {
        googleDriveService.createPostFolder(new Post(), true, 123L);
    }
}
