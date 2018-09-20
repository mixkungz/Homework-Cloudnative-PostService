package com.sit.cloudnative.PostService.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(
            method = RequestMethod.GET,
            value = "/users"
    )
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/users"
    )
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user_object = userService.createUser(user);
        return new ResponseEntity<User>(user_object,HttpStatus.OK);
    }

//    @RequestMapping(
//            value = "/users/{id}",
//            method = RequestMethod.GET
//    )
//    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
//        User user = userService.getUserById(id);
//        return new ResponseEntity<User>(user,HttpStatus.OK);
//    }



}
