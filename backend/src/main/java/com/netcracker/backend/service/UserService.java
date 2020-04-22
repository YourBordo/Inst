package com.netcracker.backend.service;

import com.netcracker.backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
     User find(String name);
     User add(User user );
     List<User>getSubscriptions(String name);
}
