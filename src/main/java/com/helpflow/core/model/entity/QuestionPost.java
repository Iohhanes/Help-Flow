package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "questions")
@ToString
public class QuestionPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_post_id")
    @Getter
    @Setter
    private Long questionPostId;

    @Column(name = "title_question", unique = true)
    @Getter
    @Setter
    private String titleQuestion;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "question_post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Getter
    @Setter
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "questionPost",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Getter
    @Setter
    private List<AnswerPost> answerPosts = new ArrayList<>();


    @OneToMany(mappedBy = "questionPostId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Getter
    @Setter
    private List<PostElement> elements = new ArrayList<>();

    public QuestionPost() {
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getQuestionPosts().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getQuestionPosts().remove(null);
    }

    public void addAnswerPost(AnswerPost answerPost) {
        answerPosts.add(answerPost);
        answerPost.setQuestionPost(this);
    }

    public void removeAnswerPost(AnswerPost answerPost) {
        answerPosts.remove(answerPost);
        answerPost.setQuestionPost(null);
    }

    public void addElement(PostElement postElement) {
        elements.add(postElement);
        postElement.setQuestionPostId(this);
    }

    public void remove(PostElement postElement) {
        elements.remove(postElement);
        postElement.setQuestionPostId(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return questionPostId != null && questionPostId.equals(((QuestionPost) o).getQuestionPostId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionPostId);
    }
}
