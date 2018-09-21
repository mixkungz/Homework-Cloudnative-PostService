package com.sit.cloudnative.PostService.Posts;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sit.cloudnative.PostService.Users.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at", "updated_at"},
        allowGetters = true)
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;

    public Post() {
    }

    public Post(@NotBlank String title, @NotBlank String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
