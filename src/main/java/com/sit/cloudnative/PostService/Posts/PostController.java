package com.sit.cloudnative.PostService.Posts;

import com.sit.cloudnative.PostService.Comments.Comment;
import com.sit.cloudnative.PostService.Comments.CommentService;
import com.sit.cloudnative.PostService.Users.User;
import com.sit.cloudnative.PostService.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.Page;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

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
        User user = userService.getUserById(new Long(1));
        post.setUser(user);
        Post post_object = postService.createPost(post);
        return new ResponseEntity<Post>(post_object,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/posts/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Post> getPost(@PathVariable("id") int id) {
        Post post = postService.getPostById(new Long(id));
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/posts/{id}/comments",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Comment>> getPostWithComment(@PathVariable("id") int id) {

        return new ResponseEntity<List<Comment>>(commentService.getAllCommentsByPostId(new Long(id)),HttpStatus.OK);
    }
}
