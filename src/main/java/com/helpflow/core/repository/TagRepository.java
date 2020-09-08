package com.helpflow.core.repository;

import com.helpflow.core.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

    public Tag findByValue(String value);
}
