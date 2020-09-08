package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_elements")
@ToString
public class PostElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_element_id")
    @Getter
    @Setter
    private Long postElementId;

    @Column(name = "fixed_text")
    @Setter
    @Getter
    private String fixedText;

    @Column(name = "image_url")
    @Getter
    @Setter
    private String imageURL;

    @OneToOne
    @JoinColumn(name = "next_element_id")
    @Getter
    @Setter
    private PostElement nextPostElement;

    @OneToOne
    @JoinColumn(name = "prev_element_id")
    @Getter
    @Setter
    private PostElement prevPostElement;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @JoinColumn(name = "answer_post_id")
    private AnswerPost answerPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @JoinColumn(name = "question_post_id")
    private QuestionPost questionPostId;

    public PostElement() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return postElementId != null && postElementId.equals(((PostElement) o).getPostElementId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(postElementId);
    }
}
