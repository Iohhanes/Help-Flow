package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
@ToString
public class AnswerPost extends Post {

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private QuestionPost questionPost;

    public AnswerPost(){
        super();
    }
}
