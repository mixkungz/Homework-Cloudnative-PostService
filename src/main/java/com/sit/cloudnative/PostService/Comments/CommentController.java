package com.sit.cloudnative.PostService.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST,value = "/comments")
    public ResponseEntity<Comment> createComment(@Valid @RequestBody Comment comment){
        Comment comment_object = commentService.createComment(comment);
        return new ResponseEntity<Comment>(comment_object,HttpStatus.OK);
    }


}
