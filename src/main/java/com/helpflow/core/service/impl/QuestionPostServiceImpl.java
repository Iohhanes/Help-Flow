package com.helpflow.core.service.impl;

import com.helpflow.core.repository.QuestionPostRepository;
import com.helpflow.core.service.QuestionPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionPostServiceImpl implements QuestionPostService {

    private QuestionPostRepository questionPostRepository;

    @Autowired
    public QuestionPostServiceImpl(QuestionPostRepository questionPostRepository) {
        this.questionPostRepository = questionPostRepository;
    }
}
