package com.helpflow.core.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    @Getter
    @Setter
    private Long postId;

    @OneToMany(mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Getter
    @Setter
    private List<PostElement> elements;

    protected Post(){
        elements = new ArrayList<>();
    }

    public void addElement(PostElement postElement) {
        elements.add(postElement);
        postElement.setPost(this);
    }

    public void remove(PostElement postElement) {
        elements.remove(postElement);
        postElement.setPost(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return postId != null && postId.equals(((Post) o).getPostId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }
}
