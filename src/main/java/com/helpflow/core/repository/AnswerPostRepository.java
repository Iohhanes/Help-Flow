package com.helpflow.core.repository;

import com.helpflow.core.model.entity.AnswerPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerPostRepository extends JpaRepository<AnswerPost, Long> {
}
