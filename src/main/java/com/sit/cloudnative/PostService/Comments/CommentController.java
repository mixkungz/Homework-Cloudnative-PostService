package com.sit.cloudnative.PostService.Comments;

import com.sit.cloudnative.PostService.Posts.Post;
import com.sit.cloudnative.PostService.Posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;



    @RequestMapping(
            method = RequestMethod.GET,
            value = "/comments"
    )
    public ResponseEntity<List<Comment>> getComment() {
        List<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
    }


    @RequestMapping(
            value = "/comments/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Comment> getComment(@PathVariable("id") int id) {
        Comment user = commentService.getCommentById(new Long(id));
        return new ResponseEntity<Comment>(user,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/comments"
    )
    public ResponseEntity<Comment> createComment(@Valid @RequestBody Comment comment){
        Post post = postService.getPostById(new Long(1));
        comment.setPost(post);
        Comment comment_object = commentService.createComment(comment);
        return new ResponseEntity<Comment>(comment_object,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/comments/{id}"
    )
    public ResponseEntity<Comment> updateComment(@PathVariable("id") int id,@Valid @RequestBody Comment comment) {
        Comment comment_object = commentService.getCommentById(new Long(id));
        comment_object.setCommentMessage(comment.getCommentMessage());
        comment_object = commentService.updateComment(comment_object);
        return new ResponseEntity<Comment>(comment_object,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/comments/{id}"
    )
    public ResponseEntity deleteComment(@PathVariable("id") int id) {
        boolean deleteStatus = commentService.deleteComment(new Long(id));
        return new ResponseEntity(deleteStatus,HttpStatus.OK);
    }


}
