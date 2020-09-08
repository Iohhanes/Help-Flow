package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "answers")
@ToString
public class AnswerPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_post_id")
    @Getter
    @Setter
    private Long answerPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @JoinColumn(name = "question_post_id")
    private QuestionPost questionPost;

    @OneToMany(mappedBy = "answerPostId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Getter
    @Setter
    private List<PostElement> elements = new ArrayList<>();

    public AnswerPost() {

    }

    public void addElement(PostElement postElement) {
        elements.add(postElement);
        postElement.setAnswerPostId(this);
    }

    public void remove(PostElement postElement) {
        elements.remove(postElement);
        postElement.setAnswerPostId(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return answerPostId != null && answerPostId.equals(((AnswerPost) o).getAnswerPostId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerPostId);
    }
}
