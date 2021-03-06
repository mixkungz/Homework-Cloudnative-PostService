package com.sit.cloudnative.PostService.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }
    public Comment getCommentById(Long id){
        return commentRepository.getOne(id);
    }
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    public List<Comment> getAllCommentsByPostId(Long postId){ return  commentRepository.findByPost_Id(postId);}
    public Comment updateComment(Comment user){ return commentRepository.saveAndFlush(user);}
    public boolean deleteComment(Long user_id){
        try{
            commentRepository.deleteById(user_id);
            return true;
        }catch(Error err){
            return false;
        }
    }
}
