package com.netcracker.fapi.controller;

import com.netcracker.fapi.entity.User;
import com.netcracker.fapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User getUserByNickname(@PathVariable(name = "userName") String nickname) {
        return userService.findByNickname(nickname);
    }
}
