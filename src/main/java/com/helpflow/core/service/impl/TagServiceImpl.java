package com.helpflow.core.service.impl;

import com.helpflow.core.model.entity.Tag;
import com.helpflow.core.repository.TagRepository;
import com.helpflow.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void createTag(String value) {
        if (tagRepository.findByValue(value) == null) {
            tagRepository.save(new Tag(value));
        }
    }
}
