package com.sit.cloudnative.PostService.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post){
        return postRepository.save(post);
    }
    public Post getPostById(Long id){
        return postRepository.getOne(id);
    }
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    public Post updateUser(Post post) {return postRepository.saveAndFlush(post);}
    public boolean deletePost(Long postId) {
        try{
            postRepository.deleteById(postId);
            return true;
        }catch(Error err){
            return false;
        }
    }
}
