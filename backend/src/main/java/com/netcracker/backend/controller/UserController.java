package com.netcracker.backend.controller;

import com.netcracker.backend.entity.User;
import com.netcracker.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByNickname(@PathVariable(name = "username") String nickname) {
        return userService.find(nickname);
    }

    @RequestMapping(value = "/subscriptions/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getSubscriptions(@PathVariable(name = "username") String nickname) {
    List<User> subscriptions = userService.getSubscriptions(nickname);
    return ResponseEntity.ok(subscriptions);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

}
