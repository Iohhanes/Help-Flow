package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@ToString
public class QuestionPost extends Post {


    @Column(name = "title_question")
    @Getter
    @Setter
    private String titleQuestion;

    @OneToMany(mappedBy = "questionPost",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Getter
    @Setter
    private List<Tag> tags;

    @OneToMany(mappedBy = "questionPost",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Getter
    @Setter
    private List<AnswerPost> answerPosts;

    public QuestionPost() {
        super();
        tags = new ArrayList<>();
        answerPosts = new ArrayList<>();
    }

    public void addTag(Tag tag){
        tags.add(tag);
        tag.setQuestionPost(this);
    }

    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.setQuestionPost(null);
    }

    public void addAnswerPost(AnswerPost answerPost){
        answerPosts.add(answerPost);
        answerPost.setQuestionPost(this);
    }

    public void removeAnswerPost(AnswerPost answerPost){
        answerPosts.remove(answerPost);
        answerPost.setQuestionPost(null);
    }
}
