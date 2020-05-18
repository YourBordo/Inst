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


    @RequestMapping(value = "/nickname/{nickname}", method = RequestMethod.GET)
    public User getUserByNickname(@PathVariable(name = "nickname") String nickname) {
        return userService.find(nickname);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "id") long id) {
        return userService.find(id);
    }

    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getSubscriptions(@PathVariable(name = "id") long id) {
    List<User> subscriptions = userService.getSubscriptions(id);
    return ResponseEntity.ok(subscriptions);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

}
