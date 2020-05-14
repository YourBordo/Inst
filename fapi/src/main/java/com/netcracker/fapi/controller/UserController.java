package com.netcracker.fapi.controller;

import com.netcracker.fapi.entity.User;
import com.netcracker.fapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserByNickname(@PathVariable(name = "id") long id) {
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

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.add(user);
    }
}
