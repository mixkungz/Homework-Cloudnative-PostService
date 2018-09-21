package com.sit.cloudnative.PostService.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }
    public Comment getCommentById(long id){
        return commentRepository.getOne(id);
    }
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
