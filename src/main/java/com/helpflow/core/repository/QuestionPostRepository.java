package com.helpflow.core.repository;

import com.helpflow.core.model.entity.QuestionPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPostRepository extends JpaRepository<QuestionPost, Long> {
}
