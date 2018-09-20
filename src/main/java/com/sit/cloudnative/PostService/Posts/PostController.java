package com.sit.cloudnative.PostService.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/posts"
    )
    public ResponseEntity<List<Post>> getPost() {
        List<Post> posts = postService.getAllPost();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/posts"
    )
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post post_object = postService.createPost(post);
        return new ResponseEntity<Post>(post_object,HttpStatus.OK);
    }
}
