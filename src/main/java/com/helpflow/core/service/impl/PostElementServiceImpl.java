package com.helpflow.core.service.impl;

import com.helpflow.core.repository.PostElementRepository;
import com.helpflow.core.service.PostElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostElementServiceImpl implements PostElementService {

    private PostElementRepository postElementRepository;

    @Autowired
    public PostElementServiceImpl(PostElementRepository postElementRepository) {
        this.postElementRepository = postElementRepository;
    }
}
