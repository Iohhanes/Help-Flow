package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tags")
@ToString
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    @Getter
    @Setter
    private Long tagId;

    @Column(unique = true)
    @Getter
    @Setter
    private String value;

    @ManyToMany(mappedBy = "tags")
    @Getter
    @Setter
    private List<QuestionPost> questionPosts = new ArrayList<>();

    public Tag() {

    }

    public Tag(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return tagId != null && tagId.equals(((Tag) o).getTagId())
                && value != null && value.equals(((Tag) o).getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, value);
    }
}
