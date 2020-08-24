package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @Getter
    @Setter
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private QuestionPost questionPost;

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
