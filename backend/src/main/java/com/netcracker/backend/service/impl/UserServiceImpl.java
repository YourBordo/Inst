package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.User;
import com.netcracker.backend.repository.UserRepository;
import com.netcracker.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User find(String name) {
        return  userRepository.findByNickname(name);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getSubscriptions(long id) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(id));
        if(user.isPresent()){
            return user.get().getSubscribedTo();
        }
        return new ArrayList<>();
    }

    @Override
    public User find(long id) {
        return userRepository.findById(id);
    }
}
