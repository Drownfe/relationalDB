package com.sofkaU.relationalDB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_like")
@NoArgsConstructor
@Data
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_like", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "dni", length = 45)
    private String dni;

    @ManyToMany
    @JoinTable(name = "comment_has_user_like",
            joinColumns = @JoinColumn(name = "user_like_iduser_like"),
            inverseJoinColumns = @JoinColumn(name = "comment_id_comments"))
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "post_has_user_like",
            joinColumns = @JoinColumn(name = "user_like_iduser_like"),
            inverseJoinColumns = @JoinColumn(name = "post_id_post"))
    private List<Post> posts = new ArrayList<>();

}
