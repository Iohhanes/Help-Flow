package com.helpflow.core.repository;

import com.helpflow.core.model.entity.PostElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostElementRepository extends JpaRepository<PostElement, Long> {
}
