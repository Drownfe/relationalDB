package com.sofkaU.relationalDB.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "number_of_likes")
    private Integer numberOfLikes;

    @JsonManagedReference
    @OneToMany(mappedBy = "postIdPost")
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "post_has_user_like",
            joinColumns = @JoinColumn(name = "post_id_post"),
            inverseJoinColumns = @JoinColumn(name = "user_like_iduser_like"))
    private List<UserLike> userLikes = new ArrayList<>();

}
