package com.helpflow.core.service;

import com.google.api.services.drive.model.File;
import com.helpflow.core.model.entity.Post;

public interface GoogleDriveService {

    File getFolder(String subQ);

    void createPostFolder(Post post, boolean isQuestionPost, long postId);
}
