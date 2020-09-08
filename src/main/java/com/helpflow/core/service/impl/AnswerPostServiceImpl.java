package com.helpflow.core.service.impl;

import com.helpflow.core.repository.AnswerPostRepository;
import com.helpflow.core.service.AnswerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerPostServiceImpl implements AnswerPostService {

    private AnswerPostRepository answerPostRepository;

    @Autowired
    public AnswerPostServiceImpl(AnswerPostRepository answerPostRepository) {
        this.answerPostRepository = answerPostRepository;
    }
}
