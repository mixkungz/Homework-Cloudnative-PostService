package com.sit.cloudnative.PostService.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    //แยก(dependency inversion) dependency ออก ดว้ย autowire
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long id){ return userRepository.getOne(id);}
    public User updateUser(User user){ return userRepository.saveAndFlush(user);}
    public boolean deleteUser(Long user_id){
        try{
            userRepository.deleteById(user_id);
            return true;
        }catch(Error err){
            return false;
        }
    }
}
