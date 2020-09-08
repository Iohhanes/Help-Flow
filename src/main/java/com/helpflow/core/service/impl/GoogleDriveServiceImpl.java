package com.helpflow.core.service.impl;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.helpflow.core.model.entity.Post;
import com.helpflow.core.service.GoogleDriveService;
import com.helpflow.core.utils.GoogleDriveFilesType;
import com.helpflow.core.utils.GoogleDriveModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class GoogleDriveServiceImpl implements GoogleDriveService {

    private Drive googleDrive;

    @Autowired
    public GoogleDriveServiceImpl(Drive googleDrive) {
        this.googleDrive = googleDrive;
    }

    @Override
    public File getFolder(String subQ) {
        File rootFolder = null;
        try {
            List<File> folders = new ArrayList<>();
            String pageToken = null;
            do {
                FileList fileListResult = googleDrive.files().list()
                        .setQ("mimeType='" + GoogleDriveFilesType.FOLDER.getMimeType() + "'" + subQ)
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name)")
                        .setPageToken(pageToken).execute();
                folders.addAll((fileListResult.getFiles()));
                pageToken = fileListResult.getNextPageToken();
            } while (pageToken != null);
            if (!folders.isEmpty()) {
                rootFolder = folders.get(0);
            }
        } catch (IOException exception) {
            log.error("Error executing: {}", exception.getMessage());
        }
        return rootFolder;
    }

    @Override
    public void createPostFolder(Post post, boolean isQuestionPost, long postId) {
        File fileMetadata = new File();
        fileMetadata.setName((isQuestionPost ? "Q" : "A") + "-" + postId);
        fileMetadata.setMimeType(GoogleDriveFilesType.FOLDER.getMimeType());
        List<String> parents = Collections.singletonList(GoogleDriveModel.ROOT_FOLDER_ID);
        fileMetadata.setParents(parents);
        try {
            File file = googleDrive.files().create(fileMetadata).setFields("id, name").execute();
            post.setFolderId(file.getId());
        } catch (IOException exception) {
            log.error("Error creating folder: {}", exception.getMessage());
        }
    }
}
